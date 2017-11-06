package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.entity.Experience;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDao extends AbstractObjectBoxDao<Experience> {

    @Inject
    public ExperienceDao(Box<Experience> box) {
        super(box);
    }
}
