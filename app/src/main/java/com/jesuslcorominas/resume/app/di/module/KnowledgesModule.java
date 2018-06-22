package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.KnowledgesPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.KnowledgesPresenterImpl;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.di.module.RepositoryModule;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;
import com.jesuslcorominas.resume.model.di.module.UseCaseModule;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {UseCaseModule.class, RepositoryModule.class})
public class KnowledgesModule {

    @Provides
    KnowledgesPresenter provideExperiencesPresenter(GetListUseCase<Knowledge> knowledgeListUseCase) {
        return new KnowledgesPresenterImpl(knowledgeListUseCase);
    }
}
