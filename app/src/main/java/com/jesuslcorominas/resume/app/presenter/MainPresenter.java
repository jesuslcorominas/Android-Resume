package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.presenter.callbackview.MainView;
import com.jesuslcorominas.resume.data.entity.PersonalData;

/**
 * @author Jesús López Corominas
 */

public interface MainPresenter extends Presenter<MainView> {

    void getPersonalData();
}
