package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.MainPresenterImpl;
import com.jesuslcorominas.resume.model.usecase.GetExperiencesListUseCase;
import com.jesuslcorominas.resume.model.di.module.ExperienceUseCaseModule;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {AppModule.class, ExperienceUseCaseModule.class})
public class MainModule {

    @Provides
    MainPresenter provideMainPresenter(GetExperiencesListUseCase getExperiencesListUseCase) {
        return new MainPresenterImpl(getExperiencesListUseCase);
    }
}
