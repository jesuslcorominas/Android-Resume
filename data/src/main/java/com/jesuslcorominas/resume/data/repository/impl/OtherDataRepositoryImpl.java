package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherDataObjectBoxEntity;
import com.jesuslcorominas.resume.model.repository.OtherDataRepository;
import com.jesuslcorominas.resume.model.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRepositoryImpl extends AbstractRepository<OtherData> implements OtherDataRepository {

    @Inject
    public OtherDataRepositoryImpl(OtherDataDatasource localDatasource, OtherDataDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
