package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.net.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataRestClientImpl extends AbstractRestClient<PersonalData, PersonalDataRestClient.Api> implements PersonalDataRestClient {

    @Inject
    public PersonalDataRestClientImpl(Retrofit retrofit, PersonalDataRestClient.Api api) {
        super(retrofit, api);
    }

    @Override
    public void list(RestClient.ListCallback<PersonalData> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<PersonalData> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, RestClient.DetailCallback<PersonalData> callback) {
        enqueueCall(api.detail(itemId), callback);
    }


}
