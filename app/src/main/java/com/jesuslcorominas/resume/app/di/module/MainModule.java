package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.MainPresenterImpl;
import com.jesuslcorominas.resume.data.di.module.RepositoryModule;
import com.jesuslcorominas.resume.model.di.module.UseCaseModule;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {UseCaseModule.class, RepositoryModule.class})
public class MainModule {

    @Provides
    MainPresenter provideMainPresenter(PersonalDataDetailUseCase personalDataDetailUseCase) {
        return new MainPresenterImpl(personalDataDetailUseCase);
    }

}
