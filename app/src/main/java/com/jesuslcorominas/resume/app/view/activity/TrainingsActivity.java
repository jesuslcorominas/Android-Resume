package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowTrainingsEvent;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.TrainingsPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.TrainingsView;
import com.jesuslcorominas.resume.app.view.fragment.TraningsFragment;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_trainings)
@SuppressLint("Registered")
public class TrainingsActivity extends AbstractBaseAppCompatActivity<TrainingsView> implements TrainingsView {

    @Inject
    TrainingsPresenter presenter;

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
    Presenter<TrainingsView> getPresenter() {
        return presenter;
    }

    @Override
    TrainingsView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getTrainingComponent().inject(this);
    }

    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_trainings_frameLayout_content, TraningsFragment.newInstance())
                .commit();
    }

    @Override
    int getErrorRes() {
        return R.string.trainings_no_data;
    }

    @Override
    int getTitleRes() {
        return R.string.trainings_title;
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetData() {
        presenter.loadTrainings();
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
        EventBus.getDefault().post(new ShowTrainingsEvent(presenter.getTrainings()));
    }

    @UiThread
    @Override
    public void hideData() {
// TODO implementar
    }
}
