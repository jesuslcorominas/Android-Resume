package com.jesuslcorominas.resume.app;

import android.app.Application;

import com.jesuslcorominas.resume.app.di.component.DaggerExperienceComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerKnowledgeComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerMainComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerOtherDataComponent;
import com.jesuslcorominas.resume.app.di.component.DaggerSplashComponent;
import com.jesuslcorominas.resume.app.di.component.ExperienceComponent;
import com.jesuslcorominas.resume.app.di.component.KnowledgeComponent;
import com.jesuslcorominas.resume.app.di.component.MainComponent;
import com.jesuslcorominas.resume.app.di.component.OtherDataComponent;
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
    private ExperienceComponent experienceComponent;
    private OtherDataComponent otherDataComponent;
    private KnowledgeComponent knowledgeComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        String endPoint = BuildConfig.END_POINT + BuildConfig.URL_WS;

        NetModule netModule = NetModule.getInstance(endPoint);
        DatabaseModule dbModule = DatabaseModule.getInstance(getFilesDir());

        mainComponent = DaggerMainComponent.builder().
                netModule(netModule).
                databaseModule(dbModule).
                build();

        experienceComponent = DaggerExperienceComponent.builder().
                netModule(netModule).
                databaseModule(dbModule).
                build();

        otherDataComponent = DaggerOtherDataComponent.builder().
                netModule(netModule).
                databaseModule(dbModule).
                build();

        knowledgeComponent = DaggerKnowledgeComponent.builder().
                netModule(netModule).
                databaseModule(dbModule).
                build();

        splashComponent = DaggerSplashComponent.builder().
                build();
    }

    public MainComponent getMainComponent() {
        return this.mainComponent;
    }

    public SplashComponent getSplashComponent() {
        return splashComponent;
    }

    public ExperienceComponent getExperienceComponent() {
        return experienceComponent;
    }

    public OtherDataComponent getOtherDataComponent() {
        return otherDataComponent;
    }

    public KnowledgeComponent getKnowledgeComponent() {
        return knowledgeComponent;
    }
}
