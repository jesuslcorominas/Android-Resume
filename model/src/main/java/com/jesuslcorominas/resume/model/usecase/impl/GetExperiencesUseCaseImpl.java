package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.model.repository.ExperienceRepository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetExperiencesUseCaseImpl extends AbstractListUseCaseImpl<Experience> {

    @Inject
    public GetExperiencesUseCaseImpl(ExperienceRepository repository) {
        super(repository);
    }
}
