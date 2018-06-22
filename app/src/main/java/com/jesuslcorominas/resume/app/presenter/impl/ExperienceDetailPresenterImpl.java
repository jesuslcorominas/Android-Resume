package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.ExperienceDetailPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.ExperienceDetailView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDetailPresenterImpl extends AbstractPresenter<ExperienceDetailView> implements ExperienceDetailPresenter {

    private Experience experience;



    public ExperienceDetailPresenterImpl() {

    }

    @Override
    public void loadExperienceById(Long id) {
//        if (resumed) {
//            showProgressAndHideOthers();
//        }
//
//        getExperienceUseCase.execute(id, new UseCase.Callback<ExperienceObjectBoxEntity>() {
//            @Override
//            public void onSuccess(ExperienceObjectBoxEntity data) {
//
//            }
//
//            @Override
//            public void onError(ErrorInfo error) {
//
//            }
//        });
    }

    @Override
    public Experience getExperience() {
        return experience;
    }
}
