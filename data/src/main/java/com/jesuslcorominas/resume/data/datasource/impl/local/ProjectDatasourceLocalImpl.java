package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.entity.Project;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Project> {

    @Inject
    public ProjectDatasourceLocalImpl(Dao<Project> dao) {
        super(dao);
    }
}
