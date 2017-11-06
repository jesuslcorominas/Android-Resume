package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.SplashPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.SplashPresenterImpl;
import com.jesuslcorominas.resume.model.di.module.PersonalDataUseCaseModule;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {AppModule.class, PersonalDataUseCaseModule.class})
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter(PersonalDataDetailUseCase personalDataDetailUseCase) {
        return new SplashPresenterImpl(personalDataDetailUseCase);
    }
}
