package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.Experience;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Experience>  {

    @Inject
    public ExperienceDatasourceLocalImpl(Dao<Experience> dao) {
        super(dao);
    }
}
