package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.entity.Knowledge;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDao extends AbstractObjectBoxDao<Knowledge> {

    @Inject
    public KnowledgeDao(Box<Knowledge> box) {
        super(box);
    }
}
