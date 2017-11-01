package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDetailUseCaseImpl extends AbstractDetailUseCaseImpl<OtherData> {

    @Inject
    public OtherDataDetailUseCaseImpl(Repository<OtherData> repository) {
        super(repository);
    }
}
