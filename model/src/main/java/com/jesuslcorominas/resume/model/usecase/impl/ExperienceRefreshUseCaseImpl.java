package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.RefreshExperienceUseCase;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class RefreshExperienceUseCaseImpl implements RefreshExperienceUseCase {

    private Repository<Experience> repository;

    public RefreshExperienceUseCaseImpl(Repository<Experience> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DateTime inputData, Callback<List<Experience>> callback) {

    }
}
