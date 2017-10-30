package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.net.RestClient;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<OtherData> {

    public OtherDataDatasourceRemoteImpl(RestClient<OtherData> restClient) {
        super(restClient);
    }
}
