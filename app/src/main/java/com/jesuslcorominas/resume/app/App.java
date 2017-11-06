package com.jesuslcorominas.resume.app;

import android.app.Application;

import com.jesuslcorominas.resume.app.di.component.DaggerMainComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerSplashComponent;
import com.jesuslcorominas.resume.app.di.component.MainComponent;
import com.jesuslcorominas.resume.app.di.component.SplashComponent;
import com.jesuslcorominas.resume.data.di.module.DatabaseModule;
import com.jesuslcorominas.resume.data.di.module.NetModule;

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

        mainComponent = DaggerMainComponent.builder().
                netModule(NetModule.getInstance(BuildConfig.END_POINT + BuildConfig.URL_WS)).
                databaseModule(DatabaseModule.getInstance(getFilesDir())).
                build();

        splashComponent = DaggerSplashComponent.builder().
                netModule(NetModule.getInstance(BuildConfig.END_POINT + BuildConfig.URL_WS)).
                databaseModule(DatabaseModule.getInstance(getFilesDir())).
                build();
    }

    public MainComponent getMainComponent() {
        return this.mainComponent;
    }

    public SplashComponent getSplashComponent() {
        return splashComponent;
    }
}
