package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.ExperienceModule;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;
import com.jesuslcorominas.resume.model.usecase.GetExperiencesListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.GetExperiencesListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = ExperienceModule.class)
public class ExperienceUseCaseModule {

    @Provides
    GetExperiencesListUseCase provideGetExperiencesListUseCase(ExperienceRepository repository) {
        return new GetExperiencesListUseCaseImpl(repository);
    }
}
