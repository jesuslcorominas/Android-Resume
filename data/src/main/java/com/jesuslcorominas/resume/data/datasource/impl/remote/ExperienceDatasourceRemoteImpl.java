package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Experience> implements ExperienceDatasource {

    @Inject
    public ExperienceDatasourceRemoteImpl(ExperienceRestClient restClient) {
        super(restClient);
    }
}
