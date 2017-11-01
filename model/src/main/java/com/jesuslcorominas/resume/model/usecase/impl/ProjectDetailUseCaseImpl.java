package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ProjectDetailUseCaseImpl extends AbstractDetailUseCaseImpl<Project> {

    @Inject
    public ProjectDetailUseCaseImpl(Repository<Project> repository) {
        super(repository);
    }
}
