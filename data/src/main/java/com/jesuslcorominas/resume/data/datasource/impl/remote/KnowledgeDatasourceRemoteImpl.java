package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Knowledge> {

    @Inject
    public KnowledgeDatasourceRemoteImpl(RestClient<Knowledge> restClient) {
        super(restClient);
    }
}
