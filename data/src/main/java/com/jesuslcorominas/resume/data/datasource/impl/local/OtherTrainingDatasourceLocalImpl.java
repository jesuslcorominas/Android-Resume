package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.OtherTrainingDao;
import com.jesuslcorominas.resume.data.datasource.OtherTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDatasourceLocalImpl implements OtherTrainingDatasource {

    private OtherTrainingDao otherTrainingDao;

    public OtherTrainingDatasourceLocalImpl(OtherTrainingDao otherTrainingDao) {
        this.otherTrainingDao = otherTrainingDao;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<OtherTraining> callback) {

    }

    @Override
    public void list(ListCallback<OtherTraining> callback) {

    }

    @Override
    public void save(OtherTraining item, SaveCallback<OtherTraining> callback) {

    }

    @Override
    public void save(List<OtherTraining> items, SaveListCallback<OtherTraining> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<OtherTraining> callback) {

    }
}
