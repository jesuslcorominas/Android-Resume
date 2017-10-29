package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.Knowledge;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDao extends AbstractObjectBoxDao<Knowledge> {

    public KnowledgeDao(Box<Knowledge> box) {
        super(box);
    }
}
