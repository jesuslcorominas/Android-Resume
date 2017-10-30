package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.Repository;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRepositoryImpl extends AbstractRepository<OtherData> {

    public OtherDataRepositoryImpl(Datasource<OtherData> localDatasource, Datasource<OtherData> remoteDatasource) {
        super(localDatasource, remoteDatasource);
    }
}
