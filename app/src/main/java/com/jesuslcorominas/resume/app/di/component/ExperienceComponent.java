package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.ExperiencesModule;
import com.jesuslcorominas.resume.app.view.activity.ExperiencesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {ExperiencesModule.class})
public interface ExperienceComponent {

    void inject(ExperiencesActivity activity);
}
