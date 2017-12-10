package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceLocalImpl extends AbstractDatasourceLocal<Experience> implements ExperienceDatasource {

    @Inject
    public ExperienceDatasourceLocalImpl(ExperienceDao dao) {
        super(dao);
    }
}
