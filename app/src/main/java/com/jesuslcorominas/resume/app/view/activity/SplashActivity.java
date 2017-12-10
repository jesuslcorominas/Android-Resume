package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.SplashView;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_splash)
@SuppressLint("Registered")
public class SplashActivity extends AbstractBaseActivity<SplashView> implements SplashView {

    @Inject
    SplashPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        callPresenterOnInit();
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
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterOnInit() {
        presenter.onInit();
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void continueToMain() {
        navigator.main(this);
    }

    @Override
    public void showErrorGettingData(ErrorInfo errorInfo) {
        // Nada que hacer aqui
    }

    @Override
    public void showData() {
        // Nada que hacer aqui
    }

    @Override
    public void hideData() {
        // Nada que hacer aqui
    }
}
