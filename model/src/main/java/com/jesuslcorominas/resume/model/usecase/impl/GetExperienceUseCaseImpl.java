package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;
import com.jesuslcorominas.resume.model.usecase.GetExperienceUseCase;

/**
 * @author Jesús López Corominas
 */
public class GetExperienceUseCaseImpl implements GetExperienceUseCase {

    private ExperienceRepository repository;

    public GetExperienceUseCaseImpl(ExperienceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Long inputData, Callback<Experience> callback) {

    }
}
