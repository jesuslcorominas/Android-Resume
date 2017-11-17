package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter() {
        return new SplashPresenterImpl();
    }
}
