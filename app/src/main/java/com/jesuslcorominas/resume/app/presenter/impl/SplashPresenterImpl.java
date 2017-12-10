package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.SplashView;

/**
 * @author Jesús López Corominas
 */
public class SplashPresenterImpl extends AbstractPresenter<SplashView> implements SplashPresenter {

    public SplashPresenterImpl() {

    }

    @Override
    public void onInit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO catch exception
        }

        callbackView.continueToMain();
    }
}
