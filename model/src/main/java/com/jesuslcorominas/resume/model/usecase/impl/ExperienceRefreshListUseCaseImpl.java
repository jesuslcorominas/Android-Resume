package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.ExperienceRefreshListUseCase;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRefreshListUseCaseImpl implements ExperienceRefreshListUseCase {

    private Repository<Experience> repository;

    @Inject
    public ExperienceRefreshListUseCaseImpl(Repository<Experience> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DateTime inputData, Callback<List<Experience>> callback) {

    }
}
