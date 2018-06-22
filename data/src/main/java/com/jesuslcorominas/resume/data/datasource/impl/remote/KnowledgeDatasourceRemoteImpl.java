package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.net.client.KnowledgeRestClient;

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
