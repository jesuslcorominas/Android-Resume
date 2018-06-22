package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.datasource.TrainingDatasource;
import com.jesuslcorominas.resume.data.net.client.TrainingRestClient;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class TrainingDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Training> implements TrainingDatasource {

    @Inject
    public TrainingDatasourceRemoteImpl(TrainingRestClient restClient) {
        super(restClient);
    }

}
