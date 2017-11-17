package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.Project;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceLocalImpl extends AbstractDatasourceLocal<Project> {

    @Inject
    public ProjectDatasourceLocalImpl(Dao<Project> dao) {
        super(dao);
    }
}
