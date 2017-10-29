package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherData;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceLocalImpl implements OtherDataDatasource {

    private OtherDataDao otherDataDao;

    public OtherDataDatasourceLocalImpl(OtherDataDao otherDataDao) {
        this.otherDataDao = otherDataDao;
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<OtherData> callback) {

    }

    @Override
    public void list(ListCallback<OtherData> callback) {

    }

    @Override
    public void save(OtherData item, SaveCallback<OtherData> callback) {

    }

    @Override
    public void save(List<OtherData> items, SaveListCallback<OtherData> callback) {

    }

    @Override
    public void detail(long itemId, DetailCallback<OtherData> callback) {

    }
}
