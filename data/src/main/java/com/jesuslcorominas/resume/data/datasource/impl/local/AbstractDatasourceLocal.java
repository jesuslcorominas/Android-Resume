package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.datasource.Datasource;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractDatasourceLocal<T> implements Datasource<T> {

    protected Dao<T> dao;

    AbstractDatasourceLocal(Dao<T> dao) {
        this.dao = dao;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<T> callback) {
        callback.onError(new ErrorInfo(Keys.ResultCodes.notImplementedError, "Método no implementado en el datasource local"));
    }

    @Override
    public void list(ListCallback<T> callback) {
        try {
            callback.onSuccess(dao.getAll());
        } catch (Exception e) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al obtener los registros de base de datos " + e.getMessage()));
        }
    }

    @Override
    public void save(T item, SaveCallback<T> callback) {
        try {
            callback.onSuccess(dao.save(item));
        } catch (Exception e) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al guardar en base de datos el elemento " + item.toString() + ": " + e.getMessage()));
        }
    }

    @Override
    public void save(List<T> items, SaveListCallback<T> callback) {
        try {
            callback.onSuccess(dao.save(items));
        } catch (Exception e) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al guardar en base de datos los elementos" + items.toString() + ": " + e.getMessage()));
        }
    }

    @Override
    public void detail(long itemId, DetailCallback<T> callback) {
        try {
            callback.onSuccess(dao.findById(itemId));
        } catch (Exception e) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al obtener el elemento con id " + itemId + ": " + e.getMessage()));
        }

    }
}
