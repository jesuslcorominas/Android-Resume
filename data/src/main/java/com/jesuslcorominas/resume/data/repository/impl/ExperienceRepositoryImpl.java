package com.jesuslcorominas.resume.data.repository.impl;


import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;
import com.jesuslcorominas.resume.model.repository.ExperienceRepository;
import com.jesuslcorominas.resume.model.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRepositoryImpl extends AbstractRepository<Experience> implements ExperienceRepository {

    @Inject
    public ExperienceRepositoryImpl(ExperienceDatasource localDatasource, ExperienceDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
