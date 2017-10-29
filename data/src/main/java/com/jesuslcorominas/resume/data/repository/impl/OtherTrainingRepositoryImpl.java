package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.OtherTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.repository.OtherTrainingRepository;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingRepositoryImpl extends AbstractRepository<OtherTraining, OtherTrainingDatasource> implements OtherTrainingRepository {

    public OtherTrainingRepositoryImpl(OtherTrainingDatasource localDatasource, OtherTrainingDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
