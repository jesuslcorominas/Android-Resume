package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.KnowledgeModule;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.KnowledgeDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.KnowledgeListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = KnowledgeModule.class)
public class KnowledgeUseCaseModule {

    @Provides
    ListUseCase<Knowledge> provideKnowledgeListUseCase(Repository<Knowledge> repository) {
        return new KnowledgeListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<Knowledge> provideKnowledgeDetailUseCase(Repository<Knowledge> repository) {
        return new KnowledgeDetailUseCaseImpl(repository);
    }

}
