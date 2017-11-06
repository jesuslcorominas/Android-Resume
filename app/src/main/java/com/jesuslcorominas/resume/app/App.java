package com.jesuslcorominas.resume.app;

import android.app.Application;

import com.jesuslcorominas.resume.app.di.component.DaggerMainComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerSplashComponent;
import com.jesuslcorominas.resume.app.di.component.MainComponent;
import com.jesuslcorominas.resume.app.di.component.SplashComponent;
import com.jesuslcorominas.resume.app.di.module.AppModule;

import org.androidannotations.annotations.EApplication;

/**
 * @author Jesús López Corominas
 */
@EApplication
public class App extends Application {

    private MainComponent mainComponent;
    private SplashComponent splashComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);

        mainComponent = DaggerMainComponent.builder().appModule(appModule).build();
        splashComponent = DaggerSplashComponent.builder().appModule(appModule).build();
    }

    public MainComponent getMainComponent() {
        return this.mainComponent;
    }

    public SplashComponent getSplashComponent() {
        return splashComponent;
    }
}
