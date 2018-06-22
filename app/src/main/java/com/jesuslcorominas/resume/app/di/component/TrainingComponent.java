package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.TrainingsModule;
import com.jesuslcorominas.resume.app.view.activity.TrainingsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {TrainingsModule.class})
public interface TrainingComponent {

    void inject(TrainingsActivity activity);
}
