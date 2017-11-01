package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.net.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<PersonalData> {

    @Inject
    public PersonalDataDatasourceRemoteImpl(RestClient<PersonalData> restClient) {
        super(restClient);
    }
}
