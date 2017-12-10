package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.view.callbackview.CallbackView;

/**
 * @author Jesús López Corominas
 */
public abstract class AbstractPresenter<V extends CallbackView> implements Presenter<V> {

    V callbackView;
    boolean resumed;

    @Override
    public void setCallbackView(V view) {
        this.callbackView = view;
    }

    @Override
    public void onResume() {
        resumed = true;
    }

    @Override
    public void onPause() {
        resumed = false;
    }

    void showProgressAndHideOthers() {
        callbackView.showProgress();

        callbackView.hideNoData();
        callbackView.hideData();
    }

    void showDataAndHideOthers() {
        callbackView.showData();

        callbackView.hideNoData();
        callbackView.hideProgress();
    }

    void showNoDataAndHideOthers() {
        callbackView.showNoData();

        callbackView.hideProgress();
        callbackView.hideData();
    }
}
