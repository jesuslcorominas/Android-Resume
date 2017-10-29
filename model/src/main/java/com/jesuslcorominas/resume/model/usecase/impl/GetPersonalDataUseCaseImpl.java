package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.GetPersonalDataUseCase;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class GetPersonalDataUseCaseImpl implements GetPersonalDataUseCase {


    PersonalDataRepository personalDataRepository;

    public GetPersonalDataUseCaseImpl(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }


    @Override
    public void execute(Void avoid, final GetPersonalDataUseCase.Callback<PersonalData> callback) {
        personalDataRepository.list(new Repository.ListCallback<PersonalData>() {
            @Override
            public void onSuccess(List<PersonalData> data) {
                if (data != null && data.size() > 0) {
                    callback.onSuccess(data.get(0));
                } else {
                    callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No hay datos personales"));
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }
}
