package com.jesuslcorominas.resume.commons;

import com.jesuslcorominas.resume.commons.ErrorInfo;

/**
 * @author Jesús López Corominas
 */
public interface GenericCallback<T> {

    void onSuccess(T data);
    void onError(ErrorInfo error);
}
