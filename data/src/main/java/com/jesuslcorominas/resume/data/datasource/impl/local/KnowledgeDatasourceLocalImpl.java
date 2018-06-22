package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;

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
