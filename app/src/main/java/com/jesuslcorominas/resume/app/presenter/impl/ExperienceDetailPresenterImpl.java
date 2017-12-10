package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.ExperienceDetailPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.ExperienceDetailView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.GetExperienceUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDetailPresenterImpl extends AbstractPresenter<ExperienceDetailView> implements ExperienceDetailPresenter {

    private Experience experience;

    private GetExperienceUseCase getExperienceUseCase;

    public ExperienceDetailPresenterImpl(GetExperienceUseCase getExperienceUseCase) {
        this.getExperienceUseCase = getExperienceUseCase;
    }

    @Override
    public void loadExperienceById(Long id) {
        if (resumed) {
            showProgressAndHideOthers();
        }

        getExperienceUseCase.execute(id, new UseCase.Callback<Experience>() {
            @Override
            public void onSuccess(Experience data) {

            }

            @Override
            public void onError(ErrorInfo error) {

            }
        });
    }

    @Override
    public Experience getExperience() {
        return experience;
    }
}
