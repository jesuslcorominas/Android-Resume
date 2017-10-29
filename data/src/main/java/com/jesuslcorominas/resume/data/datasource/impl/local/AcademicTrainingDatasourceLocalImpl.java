package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.AcademicTrainingDao;
import com.jesuslcorominas.resume.data.datasource.AcademicTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDatasourceLocalImpl implements AcademicTrainingDatasource {

    private AcademicTrainingDao academicTrainingDao;

    public AcademicTrainingDatasourceLocalImpl(AcademicTrainingDao academicTrainingDao) {
        this.academicTrainingDao = academicTrainingDao;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<AcademicTraining> callback) {

    }

    @Override
    public void list(ListCallback<AcademicTraining> callback) {

    }

    @Override
    public void save(AcademicTraining item, SaveCallback<AcademicTraining> callback) {

    }

    @Override
    public void save(List<AcademicTraining> items, SaveListCallback<AcademicTraining> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<AcademicTraining> callback) {

    }
}
