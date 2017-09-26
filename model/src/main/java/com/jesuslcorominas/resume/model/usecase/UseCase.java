package com.jesuslcorominas.resume.model.usecase;

import com.jesuslcorominas.resume.model.vo.ErrorInfo;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
public interface UseCase <I, O>{

    void execute(I inputData, Callback<O> callback);

    interface Callback <O>{
        void onSuccess(O data);
        void onError(ErrorInfo errorInfo);
    }
}
