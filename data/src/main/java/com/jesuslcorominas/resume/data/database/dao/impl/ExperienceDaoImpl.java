package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.entity.Library;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.entity.ProjectImage;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDaoImpl extends AbstractObjectBoxDao<Experience> implements ExperienceDao {

    private BoxStore boxStore;

    @Inject
    public ExperienceDaoImpl(BoxStore boxStore, Box<Experience> box) {
        super(box);
        this.boxStore = boxStore;
    }

    /**
     * Sobreescribimos el metodo save en Experience porque en la version 1.3.4 de objectbox no se
     * permite agregar objetos a una relacion si el objeto padre no esta persistido, con lo que
     * tenemos que ir guardando y agregando para que mantenga las relaciones.
     *
     * @param items Los registros a almacenar
     * @return Los items ya almacenados
     * @see @link{href="https://github.com/objectbox/objectbox-java/issues/104"}
     * <p>
     * Parece que no guarda bien en arbol de mas de dos niveles. Por eso guardamos primero las
     * Experience y una vez hecho agregamos los Project de cada Experience a la lista ProjectRelation
     * que es la que enlaza una tabla con la otra. La segunda vez que guardamos, al estar ya relacionadas
     * guarda tambien los objecto Project.
     * A partir de aqui, y por lo que deciamos de que no guarda bien en mas de 2 niveles tenemos que
     * guardar primero el objeto (lista de Library y de ProjectImage) y despues agregarlas al objeto Project
     * Al guardar luego la lista de Project de cada Experience quedan las distintas tablas relacionadas y
     * guardados los datos en disco.
     */
    @Override
    public List<Experience> save(final List<Experience> items) {
        // TODO esto deberia hacerse aqui o en la capa datasource con distintos Dao ??

        try {
            return boxStore.callInTx(new Callable<List<Experience>>() {
                @Override
                public List<Experience> call() throws Exception {
                    // Guardamos la lista de Experience
                    ExperienceDaoImpl.super.save(items);

                    for (Experience experience : items) {
                        for (Project project : experience.getProjects()) {
                            experience.getProjectsRelation().add(project);
                        }
                    }

                    // En la segunda instruccion save se guardan los Project ya relacionados
                    ExperienceDaoImpl.super.save(items);
                    for (Experience experience : items) {
                        for (Project persistedProject : experience.getProjectsRelation()) {
                            boxStore.boxFor(Library.class).put(persistedProject.getLibraries());
                            for (Library library : persistedProject.getLibraries()) {
                                persistedProject.getLibrariesRelation().add(library);
                            }

                            boxStore.boxFor(ProjectImage.class).put(persistedProject.getImages());
                            for (ProjectImage projectImage : persistedProject.getImages()) {
                                persistedProject.getImagesRelation().add(projectImage);
                            }
                        }

                        // Al guardar los Project con las listas ya agregadas quedan todos los objectos relacionados
                        boxStore.boxFor(Project.class).put(experience.getProjectsRelation());
                    }

                    return items;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar las Experiences en base de datos: " + e.getMessage());
        }
    }
}
