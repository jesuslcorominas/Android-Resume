package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.OtherDataRepository;

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
