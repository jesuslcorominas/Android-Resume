package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Training;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.TrainingRepository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetTrainingsUseCaseImpl extends AbstractListUseCaseImpl<Training> {

    @Inject
    public GetTrainingsUseCaseImpl(TrainingRepository repository) {
        super(repository);
    }
}
