package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;

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
