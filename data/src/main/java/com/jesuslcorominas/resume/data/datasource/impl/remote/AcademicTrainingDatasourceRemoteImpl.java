package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.AcademicTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.net.AcademicTrainingRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDatasourceRemoteImpl implements AcademicTrainingDatasource {

    private AcademicTrainingRestClient academicTrainingRestClient;

    public AcademicTrainingDatasourceRemoteImpl(AcademicTrainingRestClient academicTrainingRestClient) {
        this.academicTrainingRestClient = academicTrainingRestClient;
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
