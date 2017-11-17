package com.jesuslcorominas.resume.app.view.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.AbstractEvent;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.CallbackView;
import com.jesuslcorominas.resume.app.util.Navigator;
import com.jesuslcorominas.resume.app.util.Utils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@EActivity
abstract class AbstractBaseAppCompatActivity<V extends CallbackView> extends AppCompatActivity implements CallbackView {

    abstract Presenter<V> getPresenter();

    abstract V getCallbackView();

    abstract void initializeDagger();

    abstract void init();

    @StringRes
    abstract int getErrorRes();

    @StringRes
    abstract int getTitleRes();

    @Bean
    Navigator navigator;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

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

    @Override
    public void onBackPressed() {
        navigator.up(this);

        super.onBackPressed();
    }

    // ==============================
    // Inicializacion
    // ==============================
    @AfterViews
    void afterViews() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        textViewError.setText(getString(R.string.no_data, getString(getErrorRes())));

        setTitle(getTitleRes() == 0 ? "" : getString(getTitleRes()));

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
    // ActionBar
    // ==============================
    @OptionsItem(android.R.id.home)
    void homeSelected() {
        navigator.up(this);
    }

    // ==============================
    // Otros
    // ==============================
    private void initPresenter() {
        Presenter<V> presenter = getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Debes establecer un presenter para la activity");
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
