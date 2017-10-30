package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Knowledge> {

    public KnowledgeDatasourceRemoteImpl(RestClient<Knowledge> restClient) {
        super(restClient);
    }
}
