package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.OtherTraining;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDatasourceLocalImpl extends AbstractDatasourceLocalImpl<OtherTraining> {

    @Inject
    public OtherTrainingDatasourceLocalImpl(Dao<OtherTraining> dao) {
        super(dao);
    }
}
