package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.MainPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.MainView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.PersonalData;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;
import com.jesuslcorominas.resume.model.usecase.PersonalDataDetailUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

/**
 * @author Jesús López Corominas
 */
public class MainPresenterImpl extends AbstractPresenter<MainView> implements MainPresenter {

    private PersonalData personalData;

    private final PersonalDataDetailUseCase personalDataDetailUseCase;

    public MainPresenterImpl(PersonalDataDetailUseCase personalDataDetailUseCase) {
        this.personalDataDetailUseCase = personalDataDetailUseCase;
    }

    @Override
    public void loadPersonalData() {
        if (resumed) {
            showProgressAndHideOthers();
        }

        personalDataDetailUseCase.execute(null, new GetCallback<PersonalData>() {
            @Override
            public void onSuccess(PersonalData data) {
                MainPresenterImpl.this.personalData = data;
                if (resumed) {
                    showDataAndHideOthers();
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                if (resumed) {
                    showNoDataAndHideOthers();
                    callbackView.showErrorGettingData(error);
                }
            }
        });
    }

    @Override
    public PersonalData getPersonalData() {
        return personalData;
    }
}
