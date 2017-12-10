package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.utils.ServerResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public abstract class AbstractRestClient<T, R> implements RestClient<T> {

    protected R api;

    AbstractRestClient(R api) {
        this.api = api;
    }

    final void enqueueCall(Call<ServerResponse<List<T>>> call, final RestClient.ListCallback<T> callback) {
        call.enqueue(new Callback<ServerResponse<List<T>>>() {
            @Override
            public void onResponse(Call<ServerResponse<List<T>>> call, Response<ServerResponse<List<T>>> response) {
                int code = response.body().getCode();
                if (code != Keys.ResultCodes.ok) {
                    callback.onError(new ErrorInfo(code, response.body().getMessage()));
                    return;
                }

                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<ServerResponse<List<T>>> call, Throwable t) {
                callback.onError(new ErrorInfo(Keys.ResultCodes.serverError, "Error al pedir el listado: " + t.getMessage()));
            }
        });
    }
}
