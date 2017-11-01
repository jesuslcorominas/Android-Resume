package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDetailUseCaseImpl extends AbstractDetailUseCaseImpl<Knowledge> {

    @Inject
    public KnowledgeDetailUseCaseImpl(Repository<Knowledge> repository) {
        super(repository);
    }
}
