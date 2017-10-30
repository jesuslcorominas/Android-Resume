package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.ExperienceRefreshDetailUseCase;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRefreshDetailUseCaseImpl implements ExperienceRefreshDetailUseCase {

    private Repository<Experience> repository;

    @Inject
    public ExperienceRefreshDetailUseCaseImpl(Repository<Experience> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Long inputData, Callback<Experience> callback) {

    }
}
