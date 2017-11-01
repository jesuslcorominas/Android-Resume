package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.KnowledgeRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRestClientImpl extends AbstractRestClient<Knowledge, KnowledgeRestClient.Api> implements KnowledgeRestClient {

    @Inject
    public KnowledgeRestClientImpl(KnowledgeRestClient.Api api) {
        super(api);
    }

    @Override
    public void list(ListCallback<Knowledge> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Knowledge> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<Knowledge> callback) {
        enqueueCall(api.detail(itemId), callback);
    }

}
