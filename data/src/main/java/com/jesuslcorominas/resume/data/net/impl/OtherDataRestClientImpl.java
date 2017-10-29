package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.net.OtherDataRestClient;

import org.joda.time.DateTime;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRestClientImpl extends AbstractRestClient<OtherData, OtherDataRestClient.Api> implements OtherDataRestClient {

    public OtherDataRestClientImpl(Retrofit retrofit, OtherDataRestClient.Api api) {
        super(retrofit, api);
    }

    @Override
    public void list(ListCallback<OtherData> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<OtherData> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<OtherData> callback) {
        enqueueCall(api.detail(itemId), callback);
    }
}
