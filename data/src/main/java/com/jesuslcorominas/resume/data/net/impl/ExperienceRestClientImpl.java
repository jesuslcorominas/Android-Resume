package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRestClientImpl extends AbstractRestClient<Experience, ExperienceRestClient.Api> implements ExperienceRestClient {

    @Inject
    public ExperienceRestClientImpl(ExperienceRestClient.Api api) {
        super(api);
    }

    @Override
    public void list(final RestClient.ListCallback<Experience> callback) {
        enqueueCall(api.list() , callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Experience> callback) {
        enqueueCall(api.refresh(date), callback);
    }

    @Override
    public void detail(long itemId, RestClient.DetailCallback<Experience> callback) {
        enqueueCall(api.detail(itemId), callback);
    }
}
