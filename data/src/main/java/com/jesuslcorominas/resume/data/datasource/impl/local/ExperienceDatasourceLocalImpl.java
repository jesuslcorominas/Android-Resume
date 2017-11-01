package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Experience;

import org.joda.time.DateTime;

import java.util.List;

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
