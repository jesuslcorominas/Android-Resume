package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.entity.Project;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Project> {

    public ProjectDatasourceLocalImpl(Dao<Project> dao) {
        super(dao);
    }
}
