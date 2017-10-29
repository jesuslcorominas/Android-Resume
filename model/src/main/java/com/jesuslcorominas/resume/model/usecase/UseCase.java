package com.jesuslcorominas.resume.model.usecase;

import com.jesuslcorominas.resume.commons.GenericCallback;

/**
 * @author Jesús López Corominas
 */
public interface UseCase<I, O> {

    void execute(I inputData, Callback<O> callback);

    interface Callback<O> extends GenericCallback<O> {
    }

}
