package com.jesuslcorominas.resume.data.repository.impl;


import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRepositoryImpl extends AbstractRepository<Experience, ExperienceDatasource> implements ExperienceRepository {

    public ExperienceRepositoryImpl(ExperienceDatasource localDatasource, ExperienceDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
