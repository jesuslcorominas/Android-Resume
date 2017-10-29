package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceRemoteImpl implements ExperienceDatasource {

    private ExperienceRestClient restClient;

    public ExperienceDatasourceRemoteImpl(ExperienceRestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public void refresh(DateTime dateTime, final ListCallback<Experience> callback) {
        restClient.refresh(dateTime, new RestClient.ListCallback<Experience>() {
            @Override
            public void onSuccess(List<Experience> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void list(final ListCallback<Experience> callback) {
        restClient.list(new RestClient.ListCallback<Experience>() {
            @Override
            public void onSuccess(List<Experience> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void save(Experience item, SaveCallback<Experience> callback) {

    }

    @Override
    public void save(List<Experience> items, SaveListCallback<Experience> callback) {

    }

    @Override
    public void detail(long itemId, Datasource.DetailCallback<Experience> callback) {

    }
}
