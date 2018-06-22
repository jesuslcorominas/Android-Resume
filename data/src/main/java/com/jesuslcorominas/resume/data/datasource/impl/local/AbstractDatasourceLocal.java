package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.datasource.Datasource;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractDatasourceLocal<VO> implements Datasource<VO> {

    protected Dao<VO, ?> dao;

    AbstractDatasourceLocal(Dao<VO, ?> dao) {
        this.dao = dao;
    }

    @Override
    public void list(GetCallback<List<VO>> callback) {
        try {
            callback.onSuccess(dao.getAll());
        } catch (Exception e) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al obtener los registros de base de datos " + e.getMessage()));
        }
    }

    @Override
    public void save(List<VO> items, GetCallback<List<VO>> callback) {
        // TODO implementar
//        try {
//            callback.onSuccess(dao.save(items));
//        } catch (Exception e) {
//            callback.onError(new ErrorInfo(Keys.ResultCodes.databaseGenericError, "Error al guardar en base de datos los elementos" + items.toString() + ": " + e.getMessage()));
//        }
    }
}
