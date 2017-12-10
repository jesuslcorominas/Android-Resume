package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;

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
