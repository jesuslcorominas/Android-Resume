package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.model.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetPersonalDataUseCaseImpl implements PersonalDataDetailUseCase {

    private PersonalDataRepository repository;

    @Inject
    public GetPersonalDataUseCaseImpl(PersonalDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Void inputData, final GetCallback<PersonalData> callback) {
        repository.list(null, new GetCallback<List<PersonalData>>() {
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
