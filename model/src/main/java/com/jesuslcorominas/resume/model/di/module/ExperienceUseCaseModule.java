package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.ExperienceModule;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = ExperienceModule.class)
public class ExperienceUseCaseModule {

    @Provides
    ListUseCase<Experience> provideExperienceListUseCase(Repository<Experience> repository) {
        return new ExperienceListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<Experience> provideExperienceDetailUseCase(Repository<Experience> repository) {
        return new ExperienceDetailUseCaseImpl(repository);
    }

}
