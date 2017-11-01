package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceListUseCaseImpl extends AbstractListUseCaseImpl<Experience> {

    @Inject
    public ExperienceListUseCaseImpl(Repository<Experience> repository) {
        super(repository);
    }
}
