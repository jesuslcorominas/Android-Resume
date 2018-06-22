package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.database.dao.TrainingDao;
import com.jesuslcorominas.resume.data.entity.TrainingObjectBoxEntity;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class TrainingDaoImpl extends AbstractObjectBoxDao<Training, TrainingObjectBoxEntity> implements TrainingDao {

    @Inject
    public TrainingDaoImpl(Box<TrainingObjectBoxEntity> box) {
        super(box);
    }
}
