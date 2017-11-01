package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingListUseCaseImpl extends AbstractListUseCaseImpl<OtherTraining> {

    @Inject
    public OtherTrainingListUseCaseImpl(Repository<OtherTraining> repository) {
        super(repository);
    }
}
