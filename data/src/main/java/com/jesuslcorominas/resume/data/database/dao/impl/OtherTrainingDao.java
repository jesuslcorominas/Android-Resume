package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.entity.OtherTraining;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDao extends AbstractObjectBoxDao<OtherTraining> {

    @Inject
    public OtherTrainingDao(Box<OtherTraining> box) {
        super(box);
    }
}
