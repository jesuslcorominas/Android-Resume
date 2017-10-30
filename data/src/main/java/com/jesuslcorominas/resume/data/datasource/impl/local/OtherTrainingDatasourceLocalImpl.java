package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.OtherTrainingDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDatasourceLocalImpl extends AbstractDatasourceLocalImpl<OtherTraining> {

    public OtherTrainingDatasourceLocalImpl(Dao<OtherTraining> dao) {
        super(dao);
    }
}
