package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.MainPresenterImpl;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.model.di.module.ExperienceUseCaseModule;
import com.jesuslcorominas.resume.model.di.module.PersonalDataUseCaseModule;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {PersonalDataUseCaseModule.class})
public class MainModule {

    @Provides
    MainPresenter provideMainPresenter(PersonalDataDetailUseCase personalDataDetailUseCase) {
        return new MainPresenterImpl(personalDataDetailUseCase);
    }
}
