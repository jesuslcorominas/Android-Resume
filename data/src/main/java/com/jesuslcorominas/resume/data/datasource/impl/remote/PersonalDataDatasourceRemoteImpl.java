package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.net.PersonalDataRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceRemoteImpl implements PersonalDataDatasource {

    private PersonalDataRestClient personalDataRestClient;

    public PersonalDataDatasourceRemoteImpl(PersonalDataRestClient personalDataRestClient) {
        this.personalDataRestClient = personalDataRestClient;
    }

    @Override
    public void list(final Datasource.ListCallback<PersonalData> callback) {

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
