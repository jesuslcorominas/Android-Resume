package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.ExperiencesPresenterImpl;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.di.module.InteractorModule;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {InteractorModule.class})
public class ExperiencesModule {

    @Provides
    ExperiencesPresenter provideExperiencesPresenter(GetListUseCase<Experience> experienceListUseCase) {
        return new ExperiencesPresenterImpl(experienceListUseCase);
    }
}
