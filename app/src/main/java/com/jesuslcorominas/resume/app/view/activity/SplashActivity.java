package com.jesuslcorominas.resume.app.view.activity;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.SplashView;
import com.jesuslcorominas.resume.app.presenter.impl.SplashPresenterImpl;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AbstractBaseActivity<SplashView> implements SplashView {

    @Bean(SplashPresenterImpl.class)
    SplashPresenter presenter;

    // ==============================
    // Activity
    // ==============================

    // ==============================
    // AbstractBaseActivity
    // ==============================
    @Override
    Presenter<SplashView> getPresenter() {
        return presenter;
    }

    @Override
    SplashView getCallbackView() {
        return this;
    }

    @Override
    void init() {
        presenter.onInit();
    }

    // ==============================
    // SplashView
    // ==============================
    @UiThread
    @Override
    public void continueToMain() {
        navigator.main(this);
    }
}
