package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.entity.OtherData;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceLocalImpl extends AbstractDatasourceLocalImpl<OtherData> {

    @Inject
    public OtherDataDatasourceLocalImpl(Dao<OtherData> dao) {
        super(dao);
    }
}
