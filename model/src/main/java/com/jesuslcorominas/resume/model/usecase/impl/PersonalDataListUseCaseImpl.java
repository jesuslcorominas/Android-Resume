package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataListUseCaseImpl extends AbstractListUseCaseImpl<PersonalData> {

    @Inject
    public PersonalDataListUseCaseImpl(Repository<PersonalData> repository) {
        super(repository);
    }
}
