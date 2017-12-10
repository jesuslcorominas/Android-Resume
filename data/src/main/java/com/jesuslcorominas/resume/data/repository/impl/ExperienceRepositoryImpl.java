package com.jesuslcorominas.resume.data.repository.impl;


import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.entity.Library;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.entity.ProjectImage;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;

import java.util.List;

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
