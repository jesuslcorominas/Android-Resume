package com.jesuslcorominas.resume.model.usecase;

import com.jesuslcorominas.resume.commons.GetCallback;

/**
 * @author Jesús López Corominas
 */
public interface UseCase<I, O> {

    void execute(I inputData, GetCallback<O> callback);

}
