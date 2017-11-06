package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.PersonalDataModule;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.PersonalDataDetailUseCaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = PersonalDataModule.class)
@Singleton
public class PersonalDataUseCaseModule {

    @Provides
    PersonalDataDetailUseCase providePersonalDataDetailUseCase(Repository<PersonalData> repository) {
        return new PersonalDataDetailUseCaseImpl(repository);
    }

}
