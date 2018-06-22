package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.OtherDataView;
import com.jesuslcorominas.resume.commons.model.OtherData;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface OtherDataPresenter extends Presenter<OtherDataView> {

    void getOtherData();

    List<OtherData> getDatasource();
}
