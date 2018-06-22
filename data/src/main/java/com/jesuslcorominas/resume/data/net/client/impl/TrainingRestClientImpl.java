package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.net.client.TrainingRestClient;
import com.jesuslcorominas.resume.data.net.dto.TrainingDto;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class TrainingRestClientImpl extends AbstractRestClient<Training, TrainingDto, TrainingRestClient.Api> implements TrainingRestClient {

    @Inject
    public TrainingRestClientImpl(TrainingRestClient.Api api, ModelMapper mapper) {
        super(api, mapper, Training.class, TrainingDto.class,
                new TypeToken<List<Training>>() {
                },
                new TypeToken<List<TrainingDto>>() {
                }
        );
    }


    @Override
    public void list(DateTime lastDate, GetCallback<List<Training>> callback) {
        enqueueCall(api.list(lastDate), callback);
    }

}
