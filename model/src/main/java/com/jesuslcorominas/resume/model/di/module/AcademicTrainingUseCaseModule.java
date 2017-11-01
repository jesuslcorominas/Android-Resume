package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.AcademicTrainingModule;
import com.jesuslcorominas.resume.data.di.module.ExperienceModule;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.AcademicTrainingDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.AcademicTrainingListUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ExperienceListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = AcademicTrainingModule.class)
public class AcademicTrainingUseCaseModule {

    @Provides
    ListUseCase<AcademicTraining> provideExperienceListUseCase(Repository<AcademicTraining> repository) {
        return new AcademicTrainingListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<AcademicTraining> provideExperienceDetailUseCase(Repository<AcademicTraining> repository) {
        return new AcademicTrainingDetailUseCaseImpl(repository);
    }

}
