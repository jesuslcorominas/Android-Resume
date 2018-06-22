package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.model.repository.KnowledgeRepository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetKnowledgesUseCaseImpl extends AbstractListUseCaseImpl<Knowledge> {

    @Inject
    public GetKnowledgesUseCaseImpl(KnowledgeRepository repository) {
        super(repository);
    }
}
