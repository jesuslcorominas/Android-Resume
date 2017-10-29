package com.jesuslcorominas.resume.app.presenter.impl;

import android.util.Log;

import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.SplashView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

/**
 * @author Jesús López Corominas
 */
@EBean
public class SplashPresenterImpl extends AbstractPresenter<SplashView> implements SplashPresenter {

    @Background
    @Override
    public void onInit() {

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            Log.e(SplashPresenterImpl.class.getName(), "Error al pausar el splash");
        }

        if (resumed) {
            callbackView.continueToMain();
        }
    }
}
