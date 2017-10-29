package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.presenter.callbackview.CallbackView;

/**
 * @author Jesús López Corominas
 */
public interface Presenter<V extends CallbackView> {

    void setCallbackView(V view);

    void onResume();

    void onPause();

}
