package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.LanguageDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Language;

import org.joda.time.DateTime;

import java.util.List;

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
