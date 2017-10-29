package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.RefreshPersonalDataUseCase;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class RefreshPersonalDataUseCaseImpl implements RefreshPersonalDataUseCase {

    PersonalDataRepository personalDataRepository;

    public RefreshPersonalDataUseCaseImpl(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    @Override
    public void execute(DateTime inputData, final RefreshPersonalDataUseCase.Callback<PersonalData> callback) {
        personalDataRepository.refresh(inputData, new Repository.ListCallback<PersonalData>() {
            @Override
            public void onSuccess(List<PersonalData> data) {
                if (data != null && data.size() > 0) {
                    callback.onSuccess(data.get(0));
                } else {
                    callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No hay datos personales más nuevos"));
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }
}
