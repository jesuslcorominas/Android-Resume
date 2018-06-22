package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.TrainingsView;
import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.entity.TrainingObjectBoxEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface TrainingsPresenter extends Presenter<TrainingsView> {

    void loadTrainings();

    List<Training> getTrainings();
}
