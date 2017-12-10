package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceLocalImpl extends AbstractDatasourceLocal<PersonalData> implements PersonalDataDatasource {

    @Inject
    public PersonalDataDatasourceLocalImpl(PersonalDataDao dao) {
        super(dao);
    }
}
