package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowKnowledgedEvent;
import com.jesuslcorominas.resume.app.presenter.KnowledgesPresenter;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.KnowledgesView;
import com.jesuslcorominas.resume.app.view.fragment.KnowledgesFragment;
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
@EActivity(R.layout.activity_knowledges)
@SuppressLint("Registered")
public class KnowledgesActivity extends AbstractBaseAppCompatActivity<KnowledgesView> implements KnowledgesView {

    @Inject
    KnowledgesPresenter presenter;

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
    Presenter<KnowledgesView> getPresenter() {
        return presenter;
    }

    @Override
    KnowledgesView getCallbackView() {
        return this;
    }

    @Override
    int getErrorRes() {
        return R.string.knowledges_no_data;
    }

    @Override
    int getTitleRes() {
        return R.string.knowledges_title;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getKnowledgeComponent().inject(this);
    }

    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_knowledges_frameLayout_content, KnowledgesFragment.newInstance())
                .commit();
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetData() {
        presenter.getKnowledges();
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
        EventBus.getDefault().post(new ShowKnowledgedEvent(presenter.getDatasource()));
    }

    @UiThread
    @Override
    public void hideData() {
// TODO implementar
    }
}
