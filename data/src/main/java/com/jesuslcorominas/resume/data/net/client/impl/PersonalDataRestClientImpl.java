package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.net.client.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.dto.ExperienceDto;
import com.jesuslcorominas.resume.data.net.dto.PersonalDataDto;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class PersonalDataRestClientImpl extends AbstractRestClient<PersonalData, PersonalDataDto, PersonalDataRestClient.Api> implements PersonalDataRestClient {

    @Inject
    public PersonalDataRestClientImpl(PersonalDataRestClient.Api api, ModelMapper mapper) {
        super(api, mapper, PersonalData.class, PersonalDataDto.class,
                new TypeToken<List<PersonalData>>() {
                },
                new TypeToken<List<PersonalDataDto>>() {
                }
        );
    }

    @Override
    public void list(DateTime lastDate, GetCallback<List<PersonalData>> callback) {
        enqueueCall(api.list(lastDate), callback);
    }


}
