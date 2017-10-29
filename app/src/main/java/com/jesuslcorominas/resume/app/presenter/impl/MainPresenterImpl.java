package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.GetExperiencesListUseCase;
import com.jesuslcorominas.resume.model.usecase.GetPersonalDataUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.GetExperiencesListUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.GetPersonalDataUseCaseImpl;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class MainPresenterImpl extends AbstractPresenter<MainView> implements MainPresenter {

    private GetExperiencesListUseCase getExperiencesListUseCase;

    @Inject public MainPresenterImpl (GetExperiencesListUseCase getExperiencesListUseCase) {
        this.getExperiencesListUseCase = getExperiencesListUseCase;
    }

    @Override
    public void test() {
        getExperiencesListUseCase.execute(null, new GetExperiencesListUseCase.Callback<List<Experience>>() {
            @Override
            public void onSuccess(List<Experience> data) {

            }

            @Override
            public void onError(ErrorInfo error) {

            }
        });
    }
}
