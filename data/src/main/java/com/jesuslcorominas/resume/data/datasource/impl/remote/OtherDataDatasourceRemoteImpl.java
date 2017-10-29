package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.net.OtherDataRestClient;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceRemoteImpl implements OtherDataDatasource {

    private OtherDataRestClient otherDataRestClient;

    public OtherDataDatasourceRemoteImpl(OtherDataRestClient otherDataRestClient) {
        this.otherDataRestClient = otherDataRestClient;
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
