package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.data.entity.Training;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public class ShowTrainingsEvent implements Event {

    private final ArrayList<Training> trainings;

    public ShowTrainingsEvent(ArrayList<Training> trainings) {
        this.trainings = trainings;
    }

    public ArrayList<Training> getTrainings() {
        return trainings;
    }
}
