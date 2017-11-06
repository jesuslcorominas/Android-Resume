package com.jesuslcorominas.resume.app.view.activity;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.SplashView;
import com.jesuslcorominas.resume.app.presenter.impl.SplashPresenterImpl;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AbstractBaseActivity<SplashView> implements SplashView {

    @Inject
    SplashPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        presenter.onInit();
    }

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

    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getSplashComponent().inject(this);
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
