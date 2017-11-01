package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.AcademicTraining;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDao extends AbstractObjectBoxDao<AcademicTraining> {

    @Inject
    public AcademicTrainingDao(Box<AcademicTraining> box) {
        super(box);
    }
}
