package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.ProjectModule;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.ProjectDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.ProjectListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = ProjectModule.class)
public class ProjectUseCaseModule {

    @Provides
    ListUseCase<Project> provideProjectListUseCase(Repository<Project> repository) {
        return new ProjectListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<Project> provideProjectDetailUseCase(Repository<Project> repository) {
        return new ProjectDetailUseCaseImpl(repository);
    }

}
