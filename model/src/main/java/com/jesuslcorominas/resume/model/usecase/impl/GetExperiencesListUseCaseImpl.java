package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.GetExperiencesListUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetExperiencesListUseCaseImpl implements GetExperiencesListUseCase {

    private ExperienceRepository experienceRepository;

    @Inject
    public GetExperiencesListUseCaseImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public void execute(Void inputData, final Callback<List<Experience>> callback) {
        experienceRepository.list(new Repository.ListCallback<Experience>() {
            @Override
            public void onSuccess(List<Experience> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);

            }
        });
    }
}
