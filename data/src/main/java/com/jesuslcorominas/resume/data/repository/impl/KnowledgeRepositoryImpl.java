package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRepositoryImpl extends AbstractRepository<Knowledge> {

    @Inject
    public KnowledgeRepositoryImpl(Datasource<Knowledge> localDatasource, Datasource<Knowledge> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
