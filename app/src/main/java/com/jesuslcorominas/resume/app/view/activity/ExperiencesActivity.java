package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowExperiencesEvent;
import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.ExperiencesView;
import com.jesuslcorominas.resume.app.view.fragment.ExperiencesFragment;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_experiences)
@SuppressLint("Registered")
public class ExperiencesActivity extends AbstractBaseAppCompatActivity<ExperiencesView> implements ExperiencesView {

    @Inject
    ExperiencesPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        callPresenterGetData();
    }

    // ==============================
    // AbstractBaseAppCompatActivity
    // ==============================
    @Override
    Presenter<ExperiencesView> getPresenter() {
        return presenter;
    }

    @Override
    ExperiencesView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getExperienceComponent().inject(this);
    }

    @Override
    int getErrorRes() {
        return R.string.experiences_no_data;
    }

    @Override
    int getTitleRes() {
        return R.string.experiences_title;
    }

    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_experiences_frameLayout_content, ExperiencesFragment.newInstance())
                .commit();
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetData() {
        presenter.getExperiences();
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void showErrorGettingData(ErrorInfo errorInfo) {
// TODO implementar
    }

    @UiThread
    @Override
    public void showData() {
        EventBus.getDefault().post(new ShowExperiencesEvent(presenter.getDatasource()));
    }

    @UiThread
    @Override
    public void hideData() {
        // TODO implementar
    }
}
