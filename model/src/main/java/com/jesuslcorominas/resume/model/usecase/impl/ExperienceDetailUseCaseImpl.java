package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDetailUseCaseImpl extends AbstractDetailUseCaseImpl<Experience> {

    @Inject
    public ExperienceDetailUseCaseImpl(Repository<Experience> repository) {
        super(repository);
    }

}
