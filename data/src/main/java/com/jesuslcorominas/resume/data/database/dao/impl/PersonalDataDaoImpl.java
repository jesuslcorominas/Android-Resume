package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDaoImpl extends AbstractObjectBoxDao<PersonalData, PersonalDataObjectBoxEntity> implements PersonalDataDao {

    @Inject
    public PersonalDataDaoImpl(Box<PersonalDataObjectBoxEntity> box) {
        super(box);
    }
}
