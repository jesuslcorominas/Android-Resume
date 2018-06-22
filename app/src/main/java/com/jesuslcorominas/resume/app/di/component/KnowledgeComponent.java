package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.KnowledgesModule;
import com.jesuslcorominas.resume.app.view.activity.KnowledgesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {KnowledgesModule.class})
public interface KnowledgeComponent {

    void inject(KnowledgesActivity activity);
}
