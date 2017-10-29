package com.jesuslcorominas.resume.app.view.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jesuslcorominas.resume.app.App;
import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.app.presenter.impl.MainPresenterImpl;
import com.jesuslcorominas.resume.app.view.fragment.MainFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AbstractBaseAppCompatActivity<MainView> implements MainView {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawer;

    @ViewById(R.id.appBarMain_collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @ColorRes(R.color.transparent)
    int transparent;

    @Inject MainPresenter presenter;

    // ==============================
    // AbstractBaseActivity
    // ==============================
    @Override
    Presenter<MainView> getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    MainView getCallbackView() {
        return this;
    }

    @SuppressWarnings("deprecation")
    @Override
    void init() {
        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setExpandedTitleColor(transparent);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle();
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getFragmentManager().beginTransaction()
                .add(R.id.appBarMain_frameLayout_container, MainFragment.newInstance())
                .commit();

        initializeDagger();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            presenter.test();

//            super.onBackPressed();
        }
    }

    private void initializeDagger() {
        App app = (App) getApplication();
        app.getExperienceComponent().inject(this);
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
}
