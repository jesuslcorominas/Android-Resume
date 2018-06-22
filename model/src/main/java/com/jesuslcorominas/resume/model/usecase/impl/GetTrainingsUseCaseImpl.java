package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.model.repository.TrainingRepository;

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
