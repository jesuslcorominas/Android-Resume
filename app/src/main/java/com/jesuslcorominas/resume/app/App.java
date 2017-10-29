package com.jesuslcorominas.resume.app;

import android.app.Application;

import com.jesuslcorominas.resume.app.di.component.DaggerMainComponent;
import com.jesuslcorominas.resume.app.di.component.MainComponent;
import com.jesuslcorominas.resume.app.di.module.AppModule;

import org.androidannotations.annotations.EApplication;

/**
 * @author Jesús López Corominas
 */
@EApplication
public class App extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent = DaggerMainComponent.builder().appModule(new AppModule(this)).build();
    }

    public MainComponent getExperienceComponent() {
        return this.mainComponent;
    }

}
