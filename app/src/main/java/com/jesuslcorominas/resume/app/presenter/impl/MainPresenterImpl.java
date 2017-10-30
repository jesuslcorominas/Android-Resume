package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.ExperienceListUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class MainPresenterImpl extends AbstractPresenter<MainView> implements MainPresenter {

    private ExperienceListUseCase experienceListUseCase;

    @Inject public MainPresenterImpl (ExperienceListUseCase experienceListUseCase) {
        this.experienceListUseCase = experienceListUseCase;
    }

    @Override
    public void test() {
        experienceListUseCase.execute(null, new ExperienceListUseCase.Callback<List<Experience>>() {
            @Override
            public void onSuccess(List<Experience> data) {

            }

            @Override
            public void onError(ErrorInfo error) {

            }
        });
    }
}
