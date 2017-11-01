package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.Repository;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRepositoryImpl extends AbstractRepository<OtherData> {

    @Inject
    public OtherDataRepositoryImpl(Datasource<OtherData> localDatasource, Datasource<OtherData> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
