package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;

/**
 * @author Jesús López Corominas
 */
public class ShowPersonalDataEvent implements Event {

    private final PersonalData personalData;

    public ShowPersonalDataEvent(PersonalData personalData) {
        this.personalData = personalData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
