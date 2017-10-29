package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.LanguageDatasource;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.net.LanguageRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class LanguageDatasourceRemoteImpl implements LanguageDatasource {

    private LanguageRestClient languageRestClient;

    public LanguageDatasourceRemoteImpl(LanguageRestClient languageRestClient) {
        this.languageRestClient = languageRestClient;
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
