package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.data.entity.Experience;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ShowExperiencesEvent implements Event {

    private final ArrayList<Experience> experiences;

    public ShowExperiencesEvent(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }

    public ArrayList<Experience> getExperiences() {
        return experiences;
    }
}
