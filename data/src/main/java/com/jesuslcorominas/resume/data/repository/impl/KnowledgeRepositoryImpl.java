package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;
import com.jesuslcorominas.resume.model.repository.KnowledgeRepository;
import com.jesuslcorominas.resume.model.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRepositoryImpl extends AbstractRepository<Knowledge> implements KnowledgeRepository {

    @Inject
    public KnowledgeRepositoryImpl(KnowledgeDatasource localDatasource, KnowledgeDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
