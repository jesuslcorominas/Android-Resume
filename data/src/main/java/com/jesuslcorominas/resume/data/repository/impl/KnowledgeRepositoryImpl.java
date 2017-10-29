package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.KnowledgeRepository;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRepositoryImpl extends AbstractRepository<Knowledge, KnowledgeDatasource> implements KnowledgeRepository {

    public KnowledgeRepositoryImpl(KnowledgeDatasource localDatasource, KnowledgeDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
