package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.net.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<PersonalData> implements PersonalDataDatasource {

    @Inject
    public PersonalDataDatasourceRemoteImpl(PersonalDataRestClient restClient) {
        super(restClient);
    }
}
