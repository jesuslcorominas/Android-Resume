package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.commons.model.Experience;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ShowExperiencesEvent implements Event {

    private final List<Experience> experiences;

    public ShowExperiencesEvent(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }
}
