package com.jesuslcorominas.resume.app.view.activity;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

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
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_main)
@SuppressLint("Registered")
public class MainActivity extends AbstractBaseAppCompatActivity<MainView> implements MainView,
        NavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.activity_main_drawer_layout)
    DrawerLayout drawer;

    @ViewById(R.id.appBarMain_appBarLayout)
    AppBarLayout appBarLayout;

    @ViewById(R.id.appBarMain_nestedScrollViewContent)
    NestedScrollView nestedScrollViewContent;

    @ViewById(R.id.activity_main_navigatorView)
    NavigationView navigationView;

    @ViewById(R.id.layout_main)
    CoordinatorLayout layoutMain;

    @ViewById(R.id.appBarMain_imageView_mainImage)
    ImageView imageViewMainImage;

    @Inject
    MainPresenter presenter;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onResume() {
        super.onResume();

        callPresenterGetData();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // ==============================
    // AbstractBaseAppCompatActivity
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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle();
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        getFragmentManager().beginTransaction()
                .add(R.id.appBarMain_frameLayout_container, MainFragment.newInstance())
                .commit();
    }

    @Override
    int getErrorRes() {
        return R.string.personal_data_no_data;
    }

    @Override
    int getTitleRes() {
        return 0;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getMainComponent().inject(this);
    }

    // ==============================
    // DrawerMenu
    // ==============================
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
    // NavigationView.OnNavigationItemSelectedListener
    // ==============================
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.sideMenu_item_experience:
                navigator.experiences(this);
                break;
            case R.id.sideMenu_item_training:
                break;
            case R.id.sideMenu_item_knowledges:
                navigator.knowledges(this);
                break;
            case R.id.sideMenu_item_other_data:
                navigator.otherData(this);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // ==============================
    // Llamadas al presenter
    // Se hacen las llamadas al presenter en metodos aparte para poder anotarlos como @Background. Asi
    // lo que ocurra en el presenter se hace en hilos secundarios y la interfaz no queda nunca congelada
    // ==============================
    @Background
    void callPresenterGetData() {
        presenter.getPersonalData();
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void showData() {
        PersonalData personalData = presenter.getDatasource();

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
    public void hideData() {
        setTitle("");
        appBarLayout.setExpanded(false);

        nestedScrollViewContent.setVisibility(View.GONE);
    }

    @UiThread
    @Override
    public void showErrorGettingData(ErrorInfo errorInfo) {
        Snackbar.make(layoutMain, R.string.error_getting_personal_data, Snackbar.LENGTH_INDEFINITE).setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPresenterGetData();
            }
        }).show();
    }
}
