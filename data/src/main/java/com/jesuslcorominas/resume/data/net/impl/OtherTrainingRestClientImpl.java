package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.net.OtherTrainingRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingRestClientImpl extends AbstractRestClient<OtherTraining, OtherTrainingRestClient.Api> implements OtherTrainingRestClient {

    @Inject
    public OtherTrainingRestClientImpl(OtherTrainingRestClient.Api api) {
        super(api);
    }

    @Override
    public void list(ListCallback<OtherTraining> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<OtherTraining> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<OtherTraining> callback) {
        enqueueCall(api.detail(itemId), callback);
    }
}
