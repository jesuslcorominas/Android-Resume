package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Training;
import com.jesuslcorominas.resume.data.net.TrainingRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class TrainingRestClientImpl extends AbstractRestClient <Training, TrainingRestClient.Api> implements TrainingRestClient {

    @Inject
    public TrainingRestClientImpl(TrainingRestClient.Api api) {
        super(api);
    }

    @Override
    public void list(ListCallback<Training> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Training> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

}
