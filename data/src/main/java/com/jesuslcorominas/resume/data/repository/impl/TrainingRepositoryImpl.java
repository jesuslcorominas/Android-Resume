package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.datasource.TrainingDatasource;
import com.jesuslcorominas.resume.data.entity.TrainingObjectBoxEntity;
import com.jesuslcorominas.resume.model.repository.Repository;
import com.jesuslcorominas.resume.model.repository.TrainingRepository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class TrainingRepositoryImpl extends AbstractRepository<Training> implements TrainingRepository {

    @Inject
    public TrainingRepositoryImpl(TrainingDatasource localDatasource, TrainingDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
