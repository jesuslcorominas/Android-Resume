package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.OtherTrainingModule;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.OtherTrainingDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.OtherTrainingListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = OtherTrainingModule.class)
public class OtherTrainingUseCaseModule {

    @Provides
    ListUseCase<OtherTraining> provideOtherTrainingListUseCase(Repository<OtherTraining> repository) {
        return new OtherTrainingListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<OtherTraining> provideOtherTrainingDetailUseCase(Repository<OtherTraining> repository) {
        return new OtherTrainingDetailUseCaseImpl(repository);
    }

}
