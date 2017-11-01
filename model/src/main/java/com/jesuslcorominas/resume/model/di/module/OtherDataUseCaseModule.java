package com.jesuslcorominas.resume.model.di.module;

import com.jesuslcorominas.resume.data.di.module.OtherDataModule;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.DetailUseCase;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.impl.OtherDataDetailUseCaseImpl;
import com.jesuslcorominas.resume.model.usecase.impl.OtherDataListUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = OtherDataModule.class)
public class OtherDataUseCaseModule {

    @Provides
    ListUseCase<OtherData> provideOtherDataListUseCase(Repository<OtherData> repository) {
        return new OtherDataListUseCaseImpl(repository);
    }

    @Provides
    DetailUseCase<OtherData> provideOtherDataDetailUseCase(Repository<OtherData> repository) {
        return new OtherDataDetailUseCaseImpl(repository);
    }

}
