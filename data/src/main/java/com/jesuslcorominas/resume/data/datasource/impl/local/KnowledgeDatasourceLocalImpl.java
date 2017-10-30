package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Knowledge> {

    public KnowledgeDatasourceLocalImpl(Dao<Knowledge> dao) {
        super(dao);
    }
}
