package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherData;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceLocalImpl extends AbstractDatasourceLocal<OtherData> implements OtherDataDatasource {

    @Inject
    public OtherDataDatasourceLocalImpl(OtherDataDao dao) {
        super(dao);
    }
}
