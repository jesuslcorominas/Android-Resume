package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.Language;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class LanguageDatasourceLocalImpl extends AbstractDatasourceLocalImpl<Language> {

    @Inject
    public LanguageDatasourceLocalImpl(Dao<Language> dao) {
        super(dao);
    }
}
