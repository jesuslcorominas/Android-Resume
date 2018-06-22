package com.jesuslcorominas.resume.app.di.component;

import com.jesuslcorominas.resume.app.di.module.OtherDataModule;
import com.jesuslcorominas.resume.app.view.activity.OtherDataActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = {OtherDataModule.class})
public interface OtherDataComponent {

    void inject(OtherDataActivity activity);
}
