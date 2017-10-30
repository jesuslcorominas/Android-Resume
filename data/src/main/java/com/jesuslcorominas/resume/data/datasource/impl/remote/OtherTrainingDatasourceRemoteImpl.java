package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.net.OtherTrainingRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherTrainingDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<OtherTraining> {

    public OtherTrainingDatasourceRemoteImpl(RestClient<OtherTraining> restClient) {
        super(restClient);
    }
}
