package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.MainPresenterImpl;
import com.jesuslcorominas.resume.model.di.module.InteractorModule;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {InteractorModule.class})
public class MainModule {

    @Provides
    MainPresenter provideMainPresenter(PersonalDataDetailUseCase personalDataDetailUseCase) {
        return new MainPresenterImpl(personalDataDetailUseCase);
    }
}
