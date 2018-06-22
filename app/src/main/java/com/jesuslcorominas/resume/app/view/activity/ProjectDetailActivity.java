package com.jesuslcorominas.resume.app.view.activity;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.view.callbackview.ProjectDetailView;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_project_detail)
public class ProjectDetailActivity extends AbstractBaseAppCompatActivity<ProjectDetailView> implements ProjectDetailView {

    @Extra
    protected Long projectId;

    // ==============================
    // AbstractBaseAppCompatActivity
    // ==============================
    @Override
    Presenter<ProjectDetailView> getPresenter() {
        return null;
    }

    @Override
    ProjectDetailView getCallbackView() {
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
