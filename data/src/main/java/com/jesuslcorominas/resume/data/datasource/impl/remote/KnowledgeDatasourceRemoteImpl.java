package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.KnowledgeRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Knowledge> implements KnowledgeDatasource {

    @Inject
    public KnowledgeDatasourceRemoteImpl(KnowledgeRestClient restClient) {
        super(restClient);
    }
}
