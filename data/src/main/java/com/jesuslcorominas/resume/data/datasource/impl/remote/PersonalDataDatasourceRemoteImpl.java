package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.net.client.PersonalDataRestClient;

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
