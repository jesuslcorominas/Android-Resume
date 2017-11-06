package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
public class MainPresenterImpl extends AbstractPresenter<MainView> implements MainPresenter {

    private PersonalData personalData;

    private PersonalDataDetailUseCase personalDataDetailUseCase;

    public MainPresenterImpl(PersonalDataDetailUseCase personalDataDetailUseCase) {
        this.personalDataDetailUseCase = personalDataDetailUseCase;
    }

    @Override
    public void getPersonalData() {
        showProgressAndHideOthers();

        if (personalData == null) {
            personalDataDetailUseCase.execute(null, new UseCase.Callback<PersonalData>() {
                @Override
                public void onSuccess(PersonalData data) {
                    MainPresenterImpl.this.personalData = data;

                    showPersonalDataAndHideOthers();
                }

                @Override
                public void onError(ErrorInfo error) {
                    if (personalData == null) {
                        showNoDataAndHideOthers();
                    } else {
                        showPersonalDataAndHideOthers();
                    }

                    callbackView.showErrorGettingPersonalData(error);
                }
            });
        } else {
            showPersonalDataAndHideOthers();
        }
    }

    private void showProgressAndHideOthers() {
        callbackView.showProgress();

        callbackView.hideNoData();
        callbackView.hidePersonalData();
    }

    private void showPersonalDataAndHideOthers() {
        callbackView.showPersonalData(personalData);

        callbackView.hideNoData();
        callbackView.hideProgress();
    }

    private void showNoDataAndHideOthers() {
        callbackView.showNoData();

        callbackView.hideProgress();
        callbackView.hidePersonalData();
    }
}
