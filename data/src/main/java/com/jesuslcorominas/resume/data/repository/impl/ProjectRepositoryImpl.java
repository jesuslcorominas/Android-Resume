package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.ProjectDatasource;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.repository.ProjectRepository;

/**
 * @author Jesús López Corominas
 */
public class ProjectRepositoryImpl extends AbstractRepository<Project, ProjectDatasource> implements ProjectRepository {

    public ProjectRepositoryImpl(ProjectDatasource localDatasource, ProjectDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
