package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Project;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ProjectRepositoryImpl extends AbstractRepository<Project> {

    @Inject
    public ProjectRepositoryImpl(Datasource<Project> localDatasource, Datasource<Project> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
