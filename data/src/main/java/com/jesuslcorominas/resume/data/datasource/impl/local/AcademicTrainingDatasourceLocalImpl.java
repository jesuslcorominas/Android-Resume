package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDatasourceLocalImpl extends AbstractDatasourceLocalImpl<AcademicTraining> {

    @Inject
    public AcademicTrainingDatasourceLocalImpl(Dao<AcademicTraining> dao) {
        super(dao);
    }
}
