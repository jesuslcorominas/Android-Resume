package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.net.client.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.dto.ExperienceDto;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceRestClientImpl extends AbstractRestClient<Experience, ExperienceDto, ExperienceRestClient.Api> implements ExperienceRestClient {

    @Inject
    public ExperienceRestClientImpl(ExperienceRestClient.Api api, ModelMapper mapper) {
        super(api, mapper, Experience.class, ExperienceDto.class,
                new TypeToken<List<Experience>>() {
                },
                new TypeToken<List<ExperienceDto>>() {
                }
        );
    }

    @Override
    public void list(DateTime lastDate, GetCallback<List<Experience>> callback) {
        enqueueCall(api.list(lastDate), callback);
    }
}
