package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.ExperiencesPresenterImpl;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.di.module.ExperienceUseCaseModule;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {ExperienceUseCaseModule.class})
public class ExperiencesModule {

    @Provides
    ExperiencesPresenter provideExperiencesPresenter(ListUseCase<Experience> experienceListUseCase) {
        return new ExperiencesPresenterImpl(experienceListUseCase);
    }
}
