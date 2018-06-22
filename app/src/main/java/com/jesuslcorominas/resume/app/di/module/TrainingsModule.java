package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.TrainingsPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.TrainingsPresenterImpl;
import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.di.module.RepositoryModule;
import com.jesuslcorominas.resume.model.di.module.UseCaseModule;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {UseCaseModule.class, RepositoryModule.class})
public class TrainingsModule {

    @Provides
    TrainingsPresenter provideTrainingsPresenter(GetListUseCase<Training> trainingListUseCase) {
        return new TrainingsPresenterImpl(trainingListUseCase);
    }
}
