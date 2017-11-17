package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.presenter.callbackview.OtherDataView;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.entity.OtherData;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public interface OtherDataPresenter extends Presenter<OtherDataView> {

    void getOtherData();

    ArrayList<OtherData> getDatasource();
}
