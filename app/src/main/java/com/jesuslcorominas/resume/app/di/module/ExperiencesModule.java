package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.ExperiencesPresenterImpl;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.di.module.RepositoryModule;
import com.jesuslcorominas.resume.model.di.module.UseCaseModule;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {UseCaseModule.class, RepositoryModule.class})
public class ExperiencesModule {

    @Provides
    ExperiencesPresenter provideExperiencesPresenter(GetListUseCase<Experience> experienceListUseCase) {
        return new ExperiencesPresenterImpl(experienceListUseCase);
    }

}
