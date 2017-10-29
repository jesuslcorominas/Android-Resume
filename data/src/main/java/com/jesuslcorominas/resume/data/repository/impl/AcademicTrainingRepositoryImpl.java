package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.AcademicTrainingDatasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.repository.AcademicTrainingRepository;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingRepositoryImpl extends AbstractRepository<AcademicTraining, AcademicTrainingDatasource> implements AcademicTrainingRepository {

    public AcademicTrainingRepositoryImpl(AcademicTrainingDatasource localDatasource, AcademicTrainingDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
