package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.KnowledgeRecord;
import com.jesuslcorominas.resume.model.vo.Knowledge;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class KnowledgeDao extends AbstractDao<Knowledge, KnowledgeRecord> {

    @Override
    public void init() {
        setClasses(Knowledge.class, KnowledgeRecord.class);
    }
}
