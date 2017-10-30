package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.net.AcademicTrainingRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class AcademicTrainingDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<AcademicTraining> {

    public AcademicTrainingDatasourceRemoteImpl(RestClient<AcademicTraining> restClient) {
        super(restClient);
    }

}
