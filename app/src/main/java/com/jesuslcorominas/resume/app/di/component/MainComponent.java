package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.MainModule;
import com.jesuslcorominas.resume.app.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
