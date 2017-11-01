package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDetailUseCaseImpl extends AbstractDetailUseCaseImpl<AcademicTraining> {

    @Inject
    public AcademicTrainingDetailUseCaseImpl(Repository<AcademicTraining> repository) {
        super(repository);
    }
}
