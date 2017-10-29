package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.LanguageDao;
import com.jesuslcorominas.resume.data.datasource.LanguageDatasource;
import com.jesuslcorominas.resume.data.entity.Language;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class LanguageDatasourceLocalImpl implements LanguageDatasource {

    private LanguageDao languageDao;

    public LanguageDatasourceLocalImpl(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<Language> callback) {

    }

    @Override
    public void list(ListCallback<Language> callback) {

    }

    @Override
    public void save(Language item, SaveCallback<Language> callback) {

    }

    @Override
    public void save(List<Language> items, SaveListCallback<Language> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<Language> callback) {

    }
}
