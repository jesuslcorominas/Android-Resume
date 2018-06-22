package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDaoImpl extends AbstractObjectBoxDao<Knowledge, KnowledgeObjectBoxEntity> implements KnowledgeDao {

    @Inject
    public KnowledgeDaoImpl(Box<KnowledgeObjectBoxEntity> box) {
        super(box);
    }
}
