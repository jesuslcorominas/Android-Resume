package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceLocalImpl extends AbstractDatasourceLocalImpl<PersonalData> {

    public PersonalDataDatasourceLocalImpl(Dao<PersonalData> dao) {
        super(dao);
    }
}
