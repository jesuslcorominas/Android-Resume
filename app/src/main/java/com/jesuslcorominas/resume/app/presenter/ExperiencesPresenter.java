package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.ExperiencesView;
import com.jesuslcorominas.resume.commons.model.Experience;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface ExperiencesPresenter extends Presenter<ExperiencesView> {

    void loadExperiences();

    List<Experience> getExperiences();

}
