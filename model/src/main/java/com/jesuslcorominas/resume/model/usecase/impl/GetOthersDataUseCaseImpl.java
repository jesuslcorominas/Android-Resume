package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.OtherDataRepository;
import com.jesuslcorominas.resume.data.repository.Repository;

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
