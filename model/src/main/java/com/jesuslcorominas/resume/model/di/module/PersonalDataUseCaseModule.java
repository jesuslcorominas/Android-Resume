package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.PersonalDataModule;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.PersonalDataDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.PersonalDataListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = PersonalDataModule.class)
public class PersonalDataUseCaseModule {

    @Provides
    ListUseCase<PersonalData> providePersonalDataListUseCase(Repository<PersonalData> repository) {
        return new PersonalDataListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<PersonalData> providePersonalDataDetailUseCase(Repository<PersonalData> repository) {
        return new PersonalDataDetailUseCaseImpl(repository);
    }

}
