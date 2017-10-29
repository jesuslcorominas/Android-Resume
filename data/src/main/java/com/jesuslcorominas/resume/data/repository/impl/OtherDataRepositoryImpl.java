package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.OtherDataRepository;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRepositoryImpl extends AbstractRepository<OtherData, OtherDataDatasource> implements OtherDataRepository {

    public OtherDataRepositoryImpl(OtherDataDatasource localDatasource, OtherDataDatasource remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
