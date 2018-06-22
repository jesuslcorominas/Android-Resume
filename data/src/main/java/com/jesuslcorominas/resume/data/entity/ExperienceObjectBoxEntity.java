package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.commons.model.Position;
import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.PositionConverter;

import org.joda.time.DateTime;

import java.util.Comparator;
import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;

/**
 * @author Jesús López Corominas
 */
@Entity
public class ExperienceObjectBoxEntity extends AbstractObjectBoxBaseEntity {

    private String image;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime start;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime end;

    @Convert(converter = PositionConverter.class, dbType = Integer.class)
    private Position position;

    private String description;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    @Backlink
    private ToMany<ProjectObjectBoxEntity> projectsRelation;

    @Transient
    private List<ProjectObjectBoxEntity> projects;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public ToMany<ProjectObjectBoxEntity> getProjectsRelation() {
        return projectsRelation;
    }

    public void setProjectsRelation(ToMany<ProjectObjectBoxEntity> projectsRelation) {
        this.projectsRelation = projectsRelation;
    }

    public List<ProjectObjectBoxEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectObjectBoxEntity> projects) {
        this.projects = projects;
    }

    public static class ExperiencesComparator implements Comparator<ExperienceObjectBoxEntity> {

        @Override
        public int compare(ExperienceObjectBoxEntity o1, ExperienceObjectBoxEntity o2) {
            if (o1.getEnd() != null) {
                // Si el final del primero no es nulo
                if (o2.getEnd() != null) {
                    // Si el final del segundo tampoco lo, comparamos ambos finales
                    int compareEnds = o2.getEnd().compareTo(o1.getEnd());
                    if (compareEnds != 0) {
                        // Si no tienen el mismo final
                        return compareEnds;
                    }
                } else {
                    // Si estamos aqui el primero tiene fin y el segundo no, con lo que va delante
                    return 1;
                }
            } else if (o2.getEnd() != null) {
                // Si estamos aqui, el primero no tiene fin y el segundo si, con lo que el primero va delante
                return -1;
            }

            // Si estamos aqui es que ambos finales son nulos por lo que comparamos los inicios
            if (o1.getStart() != null) {
                // Si el inicio del primero no es nulo
                if (o2.getStart() != null) {
                    // Si el inicio del segundo tampoco lo, comparamos ambos inicios
                    int compareStarts = o2.getStart().compareTo(o1.getStart());
                    if (compareStarts != 0) {
                        // Si no tienen el mismo inicio
                        return compareStarts;
                    }
                } else {
                    // Si estamos aqui el primero tiene inicio y el segundo no, con lo que va delante
                    return 1;
                }
            } else if (o2.getStart() != null) {
                // Si estamos aqui, el primero no tiene inicio y el segundo si, con lo que el primero va delante
                return -1;
            }

            return Long.valueOf(o1.getId()).compareTo(o2.getId());
        }
    }

}
