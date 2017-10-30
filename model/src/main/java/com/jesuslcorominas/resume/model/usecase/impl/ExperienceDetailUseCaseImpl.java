package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.GetExperienceUseCase;

/**
 * @author Jesús López Corominas
 */
public class GetExperienceUseCaseImpl implements GetExperienceUseCase {

    private Repository<Experience> repository;

    public GetExperienceUseCaseImpl(Repository<Experience> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Long inputData, Callback<Experience> callback) {

    }
}
