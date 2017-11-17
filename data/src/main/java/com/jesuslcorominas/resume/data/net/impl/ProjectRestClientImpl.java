package com.jesuslcorominas.resume.data.net.impl;

import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.net.ProjectRestClient;

import org.joda.time.DateTime;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
public class ProjectRestClientImpl extends AbstractRestClient<Project, ProjectRestClient.Api> implements ProjectRestClient {

    @Inject
    public ProjectRestClientImpl(ProjectRestClient.Api api) {
        super(api);
    }

    @Override
    public void list(ListCallback<Project> callback) {
        enqueueCall(api.list(), callback);
    }

    @Override
    public void refresh(DateTime date, ListCallback<Project> callback) {
        enqueueCall(api.refresh(date.toString(Keys.Miscellany.internalDateFormatter)), callback);
    }

}
