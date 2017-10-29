package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.PersonalDataRepository;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataRepositoryImpl extends AbstractRepository<PersonalData, PersonalDataDatasource> implements PersonalDataRepository {

    public PersonalDataRepositoryImpl(PersonalDataDatasource localDatasource, PersonalDataDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
