package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.ProjectImage;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ProjectImageDao extends AbstractObjectBoxDao<ProjectImage> {

    public ProjectImageDao(Box<ProjectImage> box) {
        super(box);
    }
}
