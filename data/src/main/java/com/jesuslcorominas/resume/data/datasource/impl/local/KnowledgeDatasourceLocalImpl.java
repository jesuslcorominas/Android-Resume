package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceLocalImpl implements KnowledgeDatasource {

    private KnowledgeDao knowledgeDao;

    public KnowledgeDatasourceLocalImpl(KnowledgeDao knowledgeDao) {
        this.knowledgeDao = knowledgeDao;
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
