package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataDetailUseCaseImpl extends AbstractDetailUseCaseImpl<PersonalData> {

    @Inject
    public PersonalDataDetailUseCaseImpl(Repository<PersonalData> repository) {
        super(repository);
    }
}
