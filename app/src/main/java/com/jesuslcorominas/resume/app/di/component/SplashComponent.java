package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.MainModule;
import com.jesuslcorominas.resume.app.di.module.SplashModule;
import com.jesuslcorominas.resume.app.view.activity.MainActivity;
import com.jesuslcorominas.resume.app.view.activity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {SplashModule.class})
public interface SplashComponent {

    void inject(SplashActivity splashActivity);
}
