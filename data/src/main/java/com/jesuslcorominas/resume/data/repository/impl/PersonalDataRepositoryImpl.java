package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataRepositoryImpl extends AbstractRepository<PersonalData> {

    @Inject
    public PersonalDataRepositoryImpl(Datasource<PersonalData> localDatasource, Datasource<PersonalData> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
