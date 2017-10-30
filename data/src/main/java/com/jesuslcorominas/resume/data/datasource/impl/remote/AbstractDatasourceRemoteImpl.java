package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractDatasourceRemoteImpl<T> implements Datasource<T> {

    protected RestClient<T> restClient;

    public AbstractDatasourceRemoteImpl(RestClient<T> restClient) {
        this.restClient = restClient;
    }

    @Override
    public void refresh(DateTime dateTime, final ListCallback<T> callback) {
        restClient.refresh(dateTime, new RestClient.ListCallback<T>() {
            @Override
            public void onSuccess(List<T> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void list(final ListCallback<T> callback) {
        restClient.list(new RestClient.ListCallback<T>() {
            @Override
            public void onSuccess(List<T> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void save(T item, SaveCallback<T> callback) {

    }

    @Override
    public void save(List<T> items, SaveListCallback<T> callback) {

    }

    @Override
    public void detail(long itemId, Datasource.DetailCallback<T> callback) {

    }
}
