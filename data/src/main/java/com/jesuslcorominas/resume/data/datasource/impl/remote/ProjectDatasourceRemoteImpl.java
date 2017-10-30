package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.net.RestClient;

/**
 * @author Jesús López Corominas
 */
public class ProjectDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Project> {

    public ProjectDatasourceRemoteImpl(RestClient<Project> restClient) {
        super(restClient);
    }
}
