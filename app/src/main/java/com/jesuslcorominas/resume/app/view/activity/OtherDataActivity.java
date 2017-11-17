package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowOtherDataEvent;
import com.jesuslcorominas.resume.app.presenter.OtherDataPresenter;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.OtherDataView;
import com.jesuslcorominas.resume.app.view.fragment.OtherDataFragment;
import com.jesuslcorominas.resume.commons.ErrorInfo;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_other_data)
@SuppressLint("Registered")
public class OtherDataActivity extends AbstractBaseAppCompatActivity<OtherDataView> implements OtherDataView {

    @Inject
    OtherDataPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        callPresenterGetOtherData();
    }

    // ==============================
    // AbstractBaseAppCompatActivity
    // ==============================
    @Override
    Presenter<OtherDataView> getPresenter() {
        return presenter;
    }

    @Override
    OtherDataView getCallbackView() {
        return this;
    }

    @Override
    int getErrorRes() {
        return R.string.other_data_no_data;
    }

    @Override
    int getTitleRes() {
        return R.string.other_data_title;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getOtherDataComponent().inject(this);
    }

    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_otherData_frameLayout_content, OtherDataFragment.newInstance())
                .commit();
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetOtherData() {
        presenter.getOtherData();
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void showErrorGettingData(ErrorInfo errorInfo) {
        // TODO implementar
    }

    @Override
    public void showData() {
        EventBus.getDefault().post(new ShowOtherDataEvent(presenter.getDatasource()));
    }

    @Override
    public void hideData() {
// TODO implementar
    }
}
