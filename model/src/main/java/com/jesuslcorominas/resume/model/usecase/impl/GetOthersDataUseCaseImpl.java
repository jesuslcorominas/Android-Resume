package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.model.repository.OtherDataRepository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class GetOthersDataUseCaseImpl extends AbstractListUseCaseImpl<OtherData> {

    @Inject
    public GetOthersDataUseCaseImpl(OtherDataRepository repository) {
        super(repository);
    }
}
