package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Experience> {

    @Inject
    public ExperienceDatasourceRemoteImpl(RestClient<Experience> restClient) {
        super(restClient);
    }
}
