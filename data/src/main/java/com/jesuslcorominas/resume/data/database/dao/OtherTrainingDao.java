package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.OtherTraining;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDao extends AbstractObjectBoxDao<OtherTraining> {

    public OtherTrainingDao(Box<OtherTraining> box) {
        super(box);
    }
}
