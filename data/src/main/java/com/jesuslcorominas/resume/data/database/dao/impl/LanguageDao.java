package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.entity.Language;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class LanguageDao extends AbstractObjectBoxDao<Language> {

    @Inject
    public LanguageDao(Box<Language> box) {
        super(box);
    }
}
