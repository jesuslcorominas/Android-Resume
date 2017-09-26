package com.jesuslcorominas.resume.model.database.dao;


import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Jesus Lopez Corominas
 *
 * 22/09/2017
 *
 * Interface generica para el acceso a la base de datos. Expone metodos para obtener, almacenar y
 * eliminar registros de una tabla.
 *
 * @param <V> El tipo de objeto VO asociado a un objeto {@link SugarRecord}
 * @param <R> El tipo de objeto {@link SugarRecord} asociado al DAO.
 * @see @link {http://satyan.github.io/sugar/}
 */
public interface Dao<V, R extends SugarRecord> {

    /**
     * Obtiene una lista de registros de base de datos
     *
     * @return La lista de objetos persistidos
     */
    List<V> get();

    /**
     * Obtiene una lista de registros de base de datos filtrados por la columna y el valor pasados como parametros
     *
     * @param columnName  La columna por la que filtrar
     * @param filterValue El valor por el que filtrar
     * @return La lista de objetos persistidos
     */
    List<V> get(String columnName, String filterValue);

    /**
     * Obtiene una lista de registros de base de datos en funcion de la query y los parametros pasados
     *
     * @param query  Query que quieras ejecutar
     * @param params Parametros que recibe la query
     * @return La lista de registros
     */
    List<V> get(String query, String... params);

    /**
     * Almacena un registro en base de datos
     *
     * @param item El registro a almacenar
     * @return El objeto persistido
     */
    V save(V item);

    /**
     * Almacena una lista de registros en base de datos
     *
     * @param items Los registros a almacenar
     * @return La lista de objetos persistidos
     */
    List<V> save(List<V> items);

    /**
     * Elimina una lista de registros de base de datos. TIenen que ser objetos ya persistidos, es decir,
     * que tengan establecido el campo id
     *
     * @param items Los elementos a eliminar
     */
    void delete(List<V> items);

    /**
     * Elimina de base de datos todos los objetos filtrados por la columna y el valor pasados como parametros
     *
     * @param columnName  La columna por la que filtrar
     * @param filterValue El valor por el que filtrar
     */
    void delete(String columnName, String filterValue);
}
