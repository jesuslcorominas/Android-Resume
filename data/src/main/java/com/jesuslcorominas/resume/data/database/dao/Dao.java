package com.jesuslcorominas.resume.data.database.dao;

import java.util.List;

import io.objectbox.Property;
import io.objectbox.query.Query;

/**
 * Interface generica para el acceso a la base de datos. Expone metodos para obtener, almacenar y
 * eliminar registros de una tabla.
 *
 * @param <VO> El tipo de objeto VO asociado a un objeto de base de datos
 * @author Jesus Lopez Corominas
 * @see @link {http://satyan.github.io/sugar/}
 */
public interface Dao<VO, ENTITY> {
    /**
     * Obtiene una lista de registros de base de datos
     *
     * @return La lista de objetos persistidos
     */
    List<VO> getAll();

    /**
     * Obtiene una lista de registros de base de datos filtrados por la columna y el valor pasados como parametros
     *
     * @param columnProperty La columna por la que filtrar
     * @param filterValue    El valor por el que filtrar
     * @return La lista de objetos persistidos
     */
    List<VO> find(Property columnProperty, String filterValue);

    /**
     * Obtiene una lista de registros de base de datos en funcion de la query y los parametros pasados
     *
     * @param query Query que quieras ejecutar
     * @return La lista de registros
     */
    List<VO> find(Query<VO> query);

    /**
     * Obtiene el elemento cuyo id se pasa como parametro
     *
     * @param itemId El id del elemento a obtener
     * @return El elemento cuyo id se pasa como parametro
     */
    VO findById(long itemId);

    /**
     * Almacena un registro en base de datos
     *
     * @param item El registro a almacenar
     * @return El objeto persistido
     */
    VO save(VO item);

    /**
     * Almacena una lista de registros en base de datos
     *
     * @param items Los registros a almacenar
     * @return La lista de objetos persistidos
     */
    List<VO> save(List<VO> items);

    /**
     * Elimina una lista de registros de base de datos. TIenen que ser objetos ya persistidos, es decir,
     * que tengan establecido el campo id
     *
     * @param items Los elementos a eliminar
     */
    void delete(List<VO> items);

    /**
     * Elimina de base de datos todos los objetos filtrados por la columna y el valor pasados como parametros
     *
     * @param columnProperty La columna por la que filtrar
     * @param filterValue    El valor por el que filtrar
     */
    void delete(Property columnProperty, String filterValue);

    /**
     * Elimina de base de datos todos los objetos obtenidos en la query
     *
     * @param query La query por la que filtrar
     */
    void delete(Query<VO> query);
}
