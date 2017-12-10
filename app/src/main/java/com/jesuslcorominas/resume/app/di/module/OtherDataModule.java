package com.jesuslcorominas.resume.app.di.module;

import com.jesuslcorominas.resume.app.presenter.OtherDataPresenter;
import com.jesuslcorominas.resume.app.presenter.impl.OtherDataPresenterImpl;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.model.di.module.InteractorModule;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {InteractorModule.class})
public class OtherDataModule {

    @Provides
    OtherDataPresenter provideOtherDataPresenter(GetListUseCase<OtherData> otherDataListUseCase) {
        return new OtherDataPresenterImpl(otherDataListUseCase);
    }
}
