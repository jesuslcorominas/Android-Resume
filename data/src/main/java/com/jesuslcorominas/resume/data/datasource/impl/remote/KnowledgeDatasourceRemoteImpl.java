package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.KnowledgeRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceRemoteImpl implements KnowledgeDatasource {

    private KnowledgeRestClient knowledgeRestClient;

    public KnowledgeDatasourceRemoteImpl(KnowledgeRestClient knowledgeRestClient) {
        this.knowledgeRestClient = knowledgeRestClient;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<Knowledge> callback) {

    }

    @Override
    public void list(ListCallback<Knowledge> callback) {

    }

    @Override
    public void save(Knowledge item, SaveCallback<Knowledge> callback) {

    }

    @Override
    public void save(List<Knowledge> items, SaveListCallback<Knowledge> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<Knowledge> callback) {

    }
}
