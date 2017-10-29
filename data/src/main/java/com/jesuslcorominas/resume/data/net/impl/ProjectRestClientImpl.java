package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.net.ProjectRestClient;

import org.joda.time.DateTime;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class ProjectRestClientImpl extends AbstractRestClient<Project, ProjectRestClient.Api> implements ProjectRestClient {

    public ProjectRestClientImpl(Retrofit retrofit, ProjectRestClient.Api api) {
        super(retrofit, api);
    }

    @Override
    public void list(ListCallback<Project> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Project> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

    @Override
    public void detail(long itemId, DetailCallback<Project> callback) {
        enqueueCall(api.detail(itemId), callback);
    }
}
