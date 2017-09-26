package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.ExperienceRecord;
import com.jesuslcorominas.resume.model.vo.Experience;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class ExperienceDao extends AbstractDao<Experience, ExperienceRecord> {

    @Override
    public void init() {
        setClasses(Experience.class, ExperienceRecord.class);
    }
}
