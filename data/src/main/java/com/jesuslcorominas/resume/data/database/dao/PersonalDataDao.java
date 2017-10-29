package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.PersonalData;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDao extends AbstractObjectBoxDao<PersonalData> {

    public PersonalDataDao(Box<PersonalData> box) {
        super(box);
    }
}
