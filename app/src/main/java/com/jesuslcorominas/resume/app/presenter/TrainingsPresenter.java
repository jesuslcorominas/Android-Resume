package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.TrainingsView;
import com.jesuslcorominas.resume.data.entity.Training;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public interface TrainingsPresenter extends Presenter<TrainingsView> {

    void loadTrainings();

    ArrayList<Training> getTrainings();
}
