package com.jesuslcorominas.resume.data.repository.impl;


import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRepositoryImpl extends AbstractRepository<Experience> {

    @Inject
    public ExperienceRepositoryImpl(Datasource<Experience> localDatasource, Datasource<Experience> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
