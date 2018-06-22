package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.commons.model.Training;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ShowTrainingsEvent implements Event {

    private final List<Training> trainings;

    public ShowTrainingsEvent(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<Training> getTrainings() {
        return trainings;
    }
}
