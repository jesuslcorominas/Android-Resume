package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.repository.Repository;

/**
 * @author Jesús López Corominas
 */
public class LanguageRepositoryImpl extends AbstractRepository<Language> {

    public LanguageRepositoryImpl(Datasource<Language> localDatasource, Datasource<Language> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
