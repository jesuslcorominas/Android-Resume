package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.ProjectImage;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ProjectImageDao extends AbstractObjectBoxDao<ProjectImage> {

    @Inject
    public ProjectImageDao(Box<ProjectImage> box) {
        super(box);
    }
}
