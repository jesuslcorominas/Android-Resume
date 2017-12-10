package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractListUseCaseImpl<O> implements GetListUseCase<O> {

    private Repository<O> repository;

    AbstractListUseCaseImpl(Repository<O> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Void inputData, final Callback<List<O>> callback) {
        repository.list(new Repository.ListCallback<O>() {
            @Override
            public void onSuccess(List<O> data) {
                if (data == null || data.size() == 0) {
                    callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No se ha encontrado ningún elemento"));
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
