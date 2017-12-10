package com.jesuslcorominas.resume.app.view.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.AbstractEvent;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.view.callbackview.CallbackView;
import com.jesuslcorominas.resume.app.util.Navigator;
import com.jesuslcorominas.resume.app.util.Utils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


@EActivity
abstract class AbstractBaseActivity<V extends CallbackView> extends Activity implements CallbackView {

    abstract void init();

    abstract Presenter<V> getPresenter();

    abstract V getCallbackView();

    abstract void initializeDagger();

    @Bean
    Navigator navigator;

    @ViewById(R.id.layout_progress)
    LinearLayout layoutProgress;

    @ViewById(R.id.layout_sad)
    LinearLayout layoutSad;

    @ViewById(R.id.layout_sad_textView_error)
    TextView textViewError;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if (Utils.isTablet(this)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        getPresenter().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getPresenter().onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    // ==============================
    // Inicializacion
    // ==============================
    @AfterViews
    void afterViews() {
        init();

        initializeDagger();
        initPresenter();
    }

    // ==============================
    // EventBus
    // ==============================

    /**
     * Metodo sin funcionalidad unicamente para evitar errores de EventBus.
     *
     * @param event Un evento de mentira que nunca llegara a ejecutarse
     * @see com.jesuslcorominas.resume.app.event.AbstractEvent
     */
    @SuppressWarnings("unused")
    @Subscribe
    public void onEvent(AbstractEvent event) {
    }

    // ==============================
    // Otros
    // ==============================
    private void initPresenter() {
        Presenter<V> presenter = getPresenter();
        if (presenter == null) {
            throw new RuntimeException("Debes establecer un presenter para la activity");
        }

        presenter.setCallbackView(getCallbackView());
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void showProgress() {
        layoutProgress.setVisibility(View.VISIBLE);
    }

    @UiThread
    @Override
    public void hideProgress() {
        layoutProgress.setVisibility(View.GONE);
    }

    @UiThread
    @Override
    public void showNoData() {
        layoutSad.setVisibility(View.VISIBLE);
    }

    @UiThread
    @Override
    public void hideNoData() {
        layoutSad.setVisibility(View.GONE);
    }
}
