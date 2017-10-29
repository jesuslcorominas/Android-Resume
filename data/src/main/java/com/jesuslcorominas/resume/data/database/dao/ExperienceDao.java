package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.Experience;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDao extends AbstractObjectBoxDao<Experience> {

    public ExperienceDao(Box<Experience> box) {
        super(box);
    }
}
