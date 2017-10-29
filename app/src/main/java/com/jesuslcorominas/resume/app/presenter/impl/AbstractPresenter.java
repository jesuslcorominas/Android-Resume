package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.Presenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.CallbackView;

/**
 * @author Jesús López Corominas
 */
public abstract class AbstractPresenter<V extends CallbackView> implements Presenter<V> {

    protected V callbackView;
    protected boolean resumed;

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
}
