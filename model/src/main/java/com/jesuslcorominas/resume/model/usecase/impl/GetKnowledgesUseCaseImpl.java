package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.KnowledgeRepository;
import com.jesuslcorominas.resume.data.repository.Repository;

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
