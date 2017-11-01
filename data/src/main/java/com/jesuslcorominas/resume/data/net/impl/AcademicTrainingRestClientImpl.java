package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.net.AcademicTrainingRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingRestClientImpl extends AbstractRestClient <AcademicTraining, AcademicTrainingRestClient.Api> implements AcademicTrainingRestClient {

    @Inject
    public AcademicTrainingRestClientImpl(Retrofit retrofit, AcademicTrainingRestClient.Api api) {
        super(retrofit, api);
    }

    @Override
    public void list(ListCallback<AcademicTraining> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<AcademicTraining> callback) {
        enqueueCall(api.detail(itemId), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<AcademicTraining> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

}
