package com.jesuslcorominas.resume.app.view.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowPersonalDataEvent;
import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.app.util.Keys;
import com.jesuslcorominas.resume.app.view.fragment.MainFragment;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AbstractBaseAppCompatActivity<MainView> implements MainView {

    private static final String TAG = MainActivity.class.getName();

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawer;

    @ViewById(R.id.appBarMain_appBarLayout)
    AppBarLayout appBarLayout;

    @ViewById(R.id.appBarMain_nestedScrollViewContent)
    NestedScrollView nestedScrollViewContent;

    @ViewById(R.id.layout_main)
    CoordinatorLayout layoutMain;

    @ViewById(R.id.layout_progress)
    LinearLayout layoutProgress;

    @ViewById(R.id.layout_sad)
    LinearLayout layoutSad;

    @ViewById(R.id.appBarMain_imageView_mainImage)
    ImageView imageViewMainImage;

    @ViewById(R.id.layout_sad_textView_error)
    TextView textViewError;

    @StringRes(R.string.personal_data_no_data)
    String noData;

    @Inject
    MainPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        callPresenterGetPersonalData();
    }

    // ==============================
    // AbstractBaseActivity
    // ==============================
    @Override
    Presenter<MainView> getPresenter() {
        return presenter;
    }

    @Override
    MainView getCallbackView() {
        return this;
    }

    @SuppressWarnings("deprecation")
    @Override
    void init() {
        setSupportActionBar(toolbar);

        setTitle("");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle();
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getFragmentManager().beginTransaction()
                .add(R.id.appBarMain_frameLayout_container, MainFragment.newInstance())
                .commit();

        textViewError.setText(noData);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getMainComponent().inject(this);
    }

    private class ActionBarDrawerToggle extends android.support.v7.app.ActionBarDrawerToggle {
        ActionBarDrawerToggle() {
            super(MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
        }
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetPersonalData() {
        presenter.getPersonalData();
    }

    // ==============================
    // Callback
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
    public void showErrorGettingPersonalData(ErrorInfo errorInfo) {
        Snackbar.make(layoutMain, R.string.error_getting_personal_data, Snackbar.LENGTH_INDEFINITE).setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPresenterGetPersonalData();
            }
        }).show();
    }

    @UiThread
    @Override
    public void showPersonalData(PersonalData personalData) {
        setTitle(personalData.getName() + " " + personalData.getSurname());

        appBarLayout.setExpanded(true);

        EventBus.getDefault().post(new ShowPersonalDataEvent(personalData));

        nestedScrollViewContent.setVisibility(View.VISIBLE);

        Picasso.with(this).
                load(Keys.IMAGES_PATH + personalData.getImage()).
                into(imageViewMainImage);
    }

    @UiThread
    @Override
    public void hidePersonalData() {
        setTitle("");
        appBarLayout.setExpanded(false);

        nestedScrollViewContent.setVisibility(View.GONE);
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
