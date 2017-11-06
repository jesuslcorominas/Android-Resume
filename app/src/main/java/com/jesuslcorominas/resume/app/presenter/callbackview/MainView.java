package com.jesuslcorominas.resume.app.presenter.callbackview;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.PersonalData;

/**
 * @author Jesús López Corominas
 */
public interface MainView extends CallbackView {

    void showProgress();
    void hideProgress();

    void showPersonalData(PersonalData personalData);
    void hidePersonalData();

    void showNoData();
    void hideNoData();

    void showErrorGettingPersonalData(ErrorInfo errorInfo);

}
