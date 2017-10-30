package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.AcademicTrainingDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDatasourceLocalImpl extends AbstractDatasourceLocalImpl<AcademicTraining> {

    public AcademicTrainingDatasourceLocalImpl(Dao<AcademicTraining> dao) {
        super(dao);
    }
}
