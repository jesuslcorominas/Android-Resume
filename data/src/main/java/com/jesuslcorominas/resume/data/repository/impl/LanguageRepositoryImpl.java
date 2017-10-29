package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.LanguageDatasource;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.repository.LanguageRepository;

/**
 * @author Jesús López Corominas
 */
public class LanguageRepositoryImpl extends AbstractRepository<Language, LanguageDatasource> implements LanguageRepository {

    public LanguageRepositoryImpl(LanguageDatasource localDatasource, LanguageDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
