package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.TrainingDao;
import com.jesuslcorominas.resume.data.entity.Training;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class TrainingDaoImpl extends AbstractObjectBoxDao<Training> implements TrainingDao {

    @Inject
    public TrainingDaoImpl(Box<Training> box) {
        super(box);
    }
}
