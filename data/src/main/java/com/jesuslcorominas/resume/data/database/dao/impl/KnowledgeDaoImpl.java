package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDaoImpl extends AbstractObjectBoxDao<Knowledge> implements KnowledgeDao {

    @Inject
    public KnowledgeDaoImpl(Box<Knowledge> box) {
        super(box);
    }
}
