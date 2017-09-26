package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.AcademicTrainingRecord;
import com.jesuslcorominas.resume.model.vo.AcademicTraining;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class AcademicTrainingDao extends AbstractDao<AcademicTraining, AcademicTrainingRecord> {

    @Override
    public void init() {
        setClasses(AcademicTraining.class, AcademicTrainingRecord.class);
    }
}
