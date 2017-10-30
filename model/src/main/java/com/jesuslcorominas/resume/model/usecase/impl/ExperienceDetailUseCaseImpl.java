package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.ExperienceDetailUseCase;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDetailUseCaseImpl implements ExperienceDetailUseCase {

    private Repository<Experience> repository;

    @Inject
    public ExperienceDetailUseCaseImpl(Repository<Experience> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final Long inputData, final Callback<Experience> callback) {
        if (inputData == null || inputData == 0) {
            callback.onError(new ErrorInfo(Keys.ResultCodes.idNotValid, "El id no es válido"));
            return;
        }

        repository.detail(inputData, new Repository.DetailCallback<Experience>() {
            @Override
            public void onSuccess(Experience data) {
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
