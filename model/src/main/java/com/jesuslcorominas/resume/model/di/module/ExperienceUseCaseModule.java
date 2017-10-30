package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.ExperienceModule;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.ExperienceDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ExperienceListUseCase;
import com.jesuslcorominas.resume.model.usecase.ExperienceRefreshDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ExperienceRefreshListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceListUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceRefreshDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceRefreshListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = ExperienceModule.class)
public class ExperienceUseCaseModule {

    @Provides
    ExperienceListUseCase provideExperienceListUseCase(Repository<Experience> repository) {
        return new ExperienceListUseCaseImpl(repository);
    }

    @Provides
    ExperienceDetailUseCase provideExperienceDetailUseCase(Repository<Experience> repository) {
        return new ExperienceDetailUseCaseImpl(repository);
    }

    @Provides
    ExperienceRefreshListUseCase provideExperienceRefreshListUseCase(Repository<Experience> repository) {
        return new ExperienceRefreshListUseCaseImpl(repository);
    }

    @Provides
    ExperienceRefreshDetailUseCase provideExperienceRefreshDetailUseCase(Repository<Experience> repository) {
        return new ExperienceRefreshDetailUseCaseImpl(repository);
    }

}
