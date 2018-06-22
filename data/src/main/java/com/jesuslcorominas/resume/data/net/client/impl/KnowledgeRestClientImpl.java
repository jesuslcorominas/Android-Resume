package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.net.client.KnowledgeRestClient;
import com.jesuslcorominas.resume.data.net.dto.ExperienceDto;
import com.jesuslcorominas.resume.data.net.dto.KnowledgeDto;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeRestClientImpl extends AbstractRestClient<Knowledge, KnowledgeDto, KnowledgeRestClient.Api> implements KnowledgeRestClient {

    @Inject
    public KnowledgeRestClientImpl(KnowledgeRestClient.Api api, ModelMapper mapper) {
        super(api, mapper, Knowledge.class, KnowledgeDto.class,
                new TypeToken<List<Knowledge>>() {
                },
                new TypeToken<List<KnowledgeDto>>() {
                }
        );
    }

    @Override
    public void list(DateTime lastDate, GetCallback<List<Knowledge>> callback) {
        enqueueCall(api.list(lastDate), callback);
    }

}
