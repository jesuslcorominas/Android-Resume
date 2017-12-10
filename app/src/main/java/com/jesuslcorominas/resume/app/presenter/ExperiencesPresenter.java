package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.ExperiencesView;
import com.jesuslcorominas.resume.data.entity.Experience;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public interface ExperiencesPresenter extends Presenter<ExperiencesView> {

    void loadExperiences();

    ArrayList<Experience> getExperiences();

}
