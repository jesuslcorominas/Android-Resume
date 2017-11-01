package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractDetailUseCaseImpl<O> implements DetailUseCase<O> {

    private Repository<O> repository;

    AbstractDetailUseCaseImpl(Repository<O> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final Long inputData, final Callback<O> callback) {
        if (inputData == null || inputData == 0) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.idNotValid, "El id no es válido"));
            return;
        }

        repository.detail(inputData, new Repository.DetailCallback<O>() {
            @Override
            public void onSuccess(O data) {
                if (data == null) {
                    callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No se ha encontrado ningún elemento con el id " + inputData));
                    return;
                }

                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }
}
