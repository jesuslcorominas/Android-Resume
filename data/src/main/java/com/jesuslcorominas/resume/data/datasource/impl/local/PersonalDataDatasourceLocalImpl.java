package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceLocalImpl implements PersonalDataDatasource {

    private PersonalDataDao personalDataDao;

    public PersonalDataDatasourceLocalImpl(PersonalDataDao personalDataDao) {
        this.personalDataDao = personalDataDao;
    }

    @Override
    public void list(Datasource.ListCallback<PersonalData> callback) {
        callback.onSuccess(null);
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<PersonalData> callback) {

    }

    @Override
    public void save(PersonalData item, SaveCallback<PersonalData> callback) {

    }

    @Override
    public void save(List<PersonalData> items, SaveListCallback<PersonalData> callback) {

    }

    @Override
    public void detail(long itemId, Datasource.DetailCallback<PersonalData> callback) {

    }
}
