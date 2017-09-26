package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.OtherTrainingRecord;
import com.jesuslcorominas.resume.model.vo.OtherTraining;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class OtherTrainingDao extends AbstractDao<OtherTraining, OtherTrainingRecord> {

    @Override
    public void init() {
        setClasses(OtherTraining.class, OtherTrainingRecord.class);
    }
}
