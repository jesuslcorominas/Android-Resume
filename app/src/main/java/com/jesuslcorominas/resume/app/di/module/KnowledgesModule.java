package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.KnowledgesPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.KnowledgesPresenterImpl;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.model.di.module.KnowledgeUseCaseModule;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {KnowledgeUseCaseModule.class})
public class KnowledgesModule {

    @Provides
    KnowledgesPresenter provideExperiencesPresenter(ListUseCase<Knowledge> knowledgeListUseCase) {
        return new KnowledgesPresenterImpl(knowledgeListUseCase);
    }
}
