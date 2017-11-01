package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingRepositoryImpl extends AbstractRepository<OtherTraining> {

    @Inject
    public OtherTrainingRepositoryImpl(Datasource<OtherTraining> localDatasource, Datasource<OtherTraining> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
