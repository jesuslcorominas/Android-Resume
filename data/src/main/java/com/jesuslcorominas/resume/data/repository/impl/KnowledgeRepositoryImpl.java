package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.Repository;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRepositoryImpl extends AbstractRepository<Knowledge> {

    public KnowledgeRepositoryImpl(Datasource<Knowledge> localDatasource, Datasource<Knowledge> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
