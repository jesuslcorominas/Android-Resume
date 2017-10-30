package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.repository.Repository;

/**
 * @author Jesús López Corominas
 */
public class ProjectRepositoryImpl extends AbstractRepository<Project> {

    public ProjectRepositoryImpl(Datasource<Project> localDatasource, Datasource<Project> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
