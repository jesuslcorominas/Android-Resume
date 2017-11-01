package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class LanguageDetailUseCaseImpl extends AbstractDetailUseCaseImpl<Language> {

    @Inject
    public LanguageDetailUseCaseImpl(Repository<Language> repository) {
        super(repository);
    }
}
