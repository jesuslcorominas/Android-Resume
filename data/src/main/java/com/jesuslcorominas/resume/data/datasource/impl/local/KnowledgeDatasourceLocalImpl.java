package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Knowledge> {

    @Inject
    public KnowledgeDatasourceLocalImpl(Dao<Knowledge> dao) {
        super(dao);
    }
}
