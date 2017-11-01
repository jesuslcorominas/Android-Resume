package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingRepositoryImpl extends AbstractRepository<AcademicTraining> {

    @Inject
    public AcademicTrainingRepositoryImpl(Datasource<AcademicTraining> localDatasource, Datasource<AcademicTraining> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
