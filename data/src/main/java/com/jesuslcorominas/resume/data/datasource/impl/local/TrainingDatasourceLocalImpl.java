package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.database.dao.TrainingDao;
import com.jesuslcorominas.resume.data.datasource.TrainingDatasource;
import com.jesuslcorominas.resume.data.entity.TrainingObjectBoxEntity;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class TrainingDatasourceLocalImpl extends AbstractDatasourceLocal<Training> implements TrainingDatasource {

    @Inject
    public TrainingDatasourceLocalImpl(TrainingDao dao) {
        super(dao);
    }
}
