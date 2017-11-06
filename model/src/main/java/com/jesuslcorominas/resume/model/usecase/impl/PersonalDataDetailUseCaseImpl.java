package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDetailUseCaseImpl implements PersonalDataDetailUseCase {

    private Repository<PersonalData> repository;

    @Inject
    public PersonalDataDetailUseCaseImpl(Repository<PersonalData> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Void inputData, final Callback<PersonalData> callback) {
        repository.list(new Repository.ListCallback<PersonalData>() {
            @Override
            public void onSuccess(List<PersonalData> data) {
                callback.onSuccess(data.get(0));
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });

    }

}
