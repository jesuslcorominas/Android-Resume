package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.Project;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ProjectDao extends AbstractObjectBoxDao<Project> {

    @Inject
    public ProjectDao(Box<Project> box) {
        super(box);
    }
}
