package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.LanguageRecord;
import com.jesuslcorominas.resume.model.vo.Language;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class LanguageDao extends AbstractDao<Language, LanguageRecord> {

    @Override
    public void init() {
        setClasses(Language.class, LanguageRecord.class);
    }
}
