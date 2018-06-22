package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.net.client.RestClient;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractDatasourceRemoteImpl<T> implements Datasource<T> {

    private final RestClient<T> restClient;

    AbstractDatasourceRemoteImpl(RestClient<T> restClient) {
        this.restClient = restClient;
    }

    @Override
    public void list(final GetCallback<List<T>> callback) {
        restClient.list(null, new GetCallback<List<T>>() {
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
    public void save(List<T> items, GetCallback<List<T>> callback) {
// TODO implementar. Implementar la parte servidor
    }
}
