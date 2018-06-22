package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.view.callbackview.ExperienceDetailView;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_experience_detail)
@SuppressLint("Registered")
public class ExperienceDetailActivity extends AbstractBaseAppCompatActivity<ExperienceDetailView> implements ExperienceDetailView {

    @Extra
    protected Long experienceId;

    // ==============================
    // AbstractBaseAppCompatActivity
    // ==============================
    @Override
    Presenter<ExperienceDetailView> getPresenter() {
        return null;
    }

    @Override
    ExperienceDetailView getCallbackView() {
        return null;
    }

    @Override
    void initializeDagger() {

    }

    @Override
    void init() {

    }

    @Override
    int getErrorRes() {
        return 0;
    }

    @Override
    int getTitleRes() {
        return 0;
    }

    // ==============================
    // CallbackView
    // ==============================
    @Override
    public void showErrorGettingData(ErrorInfo errorInfo) {

    }

    @Override
    public void showData() {

    }

    @Override
    public void hideData() {

    }
}
