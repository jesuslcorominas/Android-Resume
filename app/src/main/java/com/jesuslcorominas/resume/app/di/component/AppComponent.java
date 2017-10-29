package com.jesuslcorominas.resume.app.di.component;

import android.content.Context;

import com.jesuslcorominas.resume.app.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context context();

}
