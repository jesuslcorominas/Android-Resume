package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.repository.Repository;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingRepositoryImpl extends AbstractRepository<OtherTraining> {

    public OtherTrainingRepositoryImpl(Datasource<OtherTraining> localDatasource, Datasource<OtherTraining> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
