package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.LanguageModule;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.LanguageDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.LanguageListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = LanguageModule.class)
public class LanguageUseCaseModule {

    @Provides
    ListUseCase<Language> provideLanguageListUseCase(Repository<Language> repository) {
        return new LanguageListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<Language> provideLanguageDetailUseCase(Repository<Language> repository) {
        return new LanguageDetailUseCaseImpl(repository);
    }

}
