package com.jesuslcorominas.resume.app.presenter.impl;

import android.util.Log;

import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.SplashView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
public class SplashPresenterImpl extends AbstractPresenter<SplashView> implements SplashPresenter {

    PersonalDataDetailUseCase personalDataDetailUseCase;

    public SplashPresenterImpl(PersonalDataDetailUseCase personalDataDetailUseCase) {
        this.personalDataDetailUseCase = personalDataDetailUseCase;
    }

    @Override
    public void onInit() {
        // Al iniciar la aplicacion pedimos los datos personales para intentar que haya datos al entrar en la pantalla principal
        personalDataDetailUseCase.execute(null, new UseCase.Callback<PersonalData>() {
            @Override
            public void onSuccess(PersonalData data) {
                if (resumed) {
                    callbackView.continueToMain();
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                if (resumed) {
                    callbackView.continueToMain();
                }
            }
        });
    }
}
