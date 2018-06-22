package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.net.client.OtherDataRestClient;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<OtherData> implements OtherDataDatasource {

    @Inject
    public OtherDataDatasourceRemoteImpl(OtherDataRestClient restClient) {
        super(restClient);
    }
}
