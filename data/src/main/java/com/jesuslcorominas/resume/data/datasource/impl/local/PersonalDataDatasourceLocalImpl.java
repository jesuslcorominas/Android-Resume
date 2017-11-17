package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceLocalImpl extends AbstractDatasourceLocal<PersonalData> {

    @Inject
    public PersonalDataDatasourceLocalImpl(Dao<PersonalData> dao) {
        super(dao);
    }
}
