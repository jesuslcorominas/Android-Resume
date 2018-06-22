package com.jesuslcorominas.resume.app.view.callbackview;

import com.jesuslcorominas.resume.commons.ErrorInfo;

/**
 * @author Jesús López Corominas
 */
public interface CallbackView {

    void showErrorGettingData(ErrorInfo errorInfo);

    void showProgress();

    void hideProgress();

    void showNoData();

    void hideNoData();

    void showData();

    void hideData();
}
