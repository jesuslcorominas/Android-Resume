package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.ExperienceDetailView;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;

/**
 * @author Jesús López Corominas
 */
public interface ExperienceDetailPresenter extends Presenter<ExperienceDetailView> {

    void loadExperienceById(Long id);

    Experience getExperience();
}
