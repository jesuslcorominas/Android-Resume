package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDaoImpl extends AbstractObjectBoxDao<PersonalData> implements PersonalDataDao {

    @Inject
    public PersonalDataDaoImpl(Box<PersonalData> box) {
        super(box);
    }
}
