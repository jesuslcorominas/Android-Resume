package com.jesuslcorominas.resume.commons;

/**
 * @author Jesús López Corominas
 */
public interface GetCallback<T> extends GenericCallback {

    void onSuccess(T result);

}
