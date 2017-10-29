package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.ProjectDao;
import com.jesuslcorominas.resume.data.datasource.ProjectDatasource;
import com.jesuslcorominas.resume.data.entity.Project;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceLocalImpl implements ProjectDatasource {

    private ProjectDao projectDao;

    public ProjectDatasourceLocalImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
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
