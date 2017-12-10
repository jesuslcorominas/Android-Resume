package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.KnowledgeRepository;

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
