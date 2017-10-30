package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.OtherData;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceLocalImpl extends AbstractDatasourceLocalImpl<OtherData> {

    public OtherDataDatasourceLocalImpl(Dao<OtherData> dao) {
        super(dao);
    }
}
