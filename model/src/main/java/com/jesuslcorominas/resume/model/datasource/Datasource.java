package com.jesuslcorominas.resume.model.datasource;

import com.jesuslcorominas.resume.model.vo.ErrorInfo;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
public interface Datasource <T>{

    interface Callback<T> {
        void onSuccess(T data);
        void onError(ErrorInfo errorInfo);
    }
}
