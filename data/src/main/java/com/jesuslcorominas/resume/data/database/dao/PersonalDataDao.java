package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.PersonalData;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDao extends AbstractObjectBoxDao<PersonalData> {

    @Inject
    public PersonalDataDao(Box<PersonalData> box) {
        super(box);
    }
}
