package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.net.LanguageRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class LanguageRestClientImpl extends AbstractRestClient<Language, LanguageRestClient.Api> implements LanguageRestClient {

    @Inject
    public LanguageRestClientImpl(Retrofit retrofit,LanguageRestClient.Api api) {
        super(retrofit, api);
    }

    @Override
    public void list(ListCallback<Language> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Language> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<Language> callback) {
        enqueueCall(api.detail(itemId), callback);
    }
}
