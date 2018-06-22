package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;
import com.jesuslcorominas.resume.model.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.model.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataRepositoryImpl extends AbstractRepository<PersonalData> implements PersonalDataRepository {

    @Inject
    public PersonalDataRepositoryImpl(PersonalDataDatasource localDatasource, PersonalDataDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
