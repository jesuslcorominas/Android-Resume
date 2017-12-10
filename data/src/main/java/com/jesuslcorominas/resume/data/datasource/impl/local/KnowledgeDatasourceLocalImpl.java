package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceLocalImpl extends AbstractDatasourceLocal<Knowledge> implements KnowledgeDatasource {

    @Inject
    public KnowledgeDatasourceLocalImpl(KnowledgeDao dao) {
        super(dao);
    }
}
