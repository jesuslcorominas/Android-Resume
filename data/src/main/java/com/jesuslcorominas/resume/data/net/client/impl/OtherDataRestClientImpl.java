package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.data.net.client.OtherDataRestClient;
import com.jesuslcorominas.resume.data.net.dto.OtherDataDto;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class OtherDataRestClientImpl extends AbstractRestClient<OtherData, OtherDataDto, OtherDataRestClient.Api> implements OtherDataRestClient {

    @Inject
    public OtherDataRestClientImpl(OtherDataRestClient.Api api, ModelMapper mapper) {
        super(api, mapper, OtherData.class, OtherDataDto.class,
                new TypeToken<List<OtherData>>() {
                },
                new TypeToken<List<OtherDataDto>>() {
                }
        );
    }

    @Override
    public void list(DateTime lastDate, GetCallback<List<OtherData>> callback) {
        enqueueCall(api.list(lastDate), callback);
    }
}
