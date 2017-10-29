package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.ProjectDatasource;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.net.ProjectRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceRemoteImpl implements ProjectDatasource {

    private ProjectRestClient projectRestClient;

    public ProjectDatasourceRemoteImpl(ProjectRestClient projectRestClient) {
        this.projectRestClient = projectRestClient;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<Project> callback) {

    }

    @Override
    public void list(ListCallback<Project> callback) {

    }

    @Override
    public void save(Project item, SaveCallback<Project> callback) {

    }

    @Override
    public void save(List<Project> items, SaveListCallback<Project> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<Project> callback) {

    }
}
