package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.PersonalDataRecord;
import com.jesuslcorominas.resume.model.vo.PersonalData;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class PersonalDataDao extends AbstractDao<PersonalData, PersonalDataRecord> {

    @Override
    public void init() {
        setClasses(PersonalData.class, PersonalDataRecord.class);
    }
}
