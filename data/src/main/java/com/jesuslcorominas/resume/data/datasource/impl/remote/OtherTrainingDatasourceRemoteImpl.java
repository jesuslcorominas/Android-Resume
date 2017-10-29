package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.OtherTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.net.OtherTrainingRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDatasourceRemoteImpl implements OtherTrainingDatasource {

    private OtherTrainingRestClient otherTrainingRestClient;

    public OtherTrainingDatasourceRemoteImpl(OtherTrainingRestClient otherTrainingRestClient) {
        this.otherTrainingRestClient = otherTrainingRestClient;
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
