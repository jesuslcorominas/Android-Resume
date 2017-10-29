package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.Project;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ProjectDao extends AbstractObjectBoxDao<Project> {

    public ProjectDao(Box<Project> box) {
        super(box);
    }
}
