package com.jesuslcorominas.resume.model.di.module;


import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.model.repository.ExperienceRepository;
import com.jesuslcorominas.resume.model.repository.KnowledgeRepository;
import com.jesuslcorominas.resume.model.repository.OtherDataRepository;
import com.jesuslcorominas.resume.model.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.model.repository.TrainingRepository;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.GetExperiencesUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.GetKnowledgesUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.GetOthersDataUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.GetPersonalDataUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.GetTrainingsUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class UseCaseModule {

    @Provides
    GetListUseCase<Training> provideGetTrainingsUseCase(TrainingRepository repository) {
        return new GetTrainingsUseCaseImpl(repository);
    }

    @Provides
    GetListUseCase<Experience> provideGetExperiencesUseCase(ExperienceRepository repository) {
        return new GetExperiencesUseCaseImpl(repository);
    }

    @Provides
    GetListUseCase<Knowledge> provideGetKnowledgesUseCase(KnowledgeRepository repository) {
        return new GetKnowledgesUseCaseImpl(repository);
    }

    @Provides
    GetListUseCase<OtherData> provideGetOthersDataUseCase(OtherDataRepository repository) {
        return new GetOthersDataUseCaseImpl(repository);
    }

    @Provides
    PersonalDataDetailUseCase provideGetPersonalDataUseCase(PersonalDataRepository repository) {
        return new GetPersonalDataUseCaseImpl(repository);
    }
}
