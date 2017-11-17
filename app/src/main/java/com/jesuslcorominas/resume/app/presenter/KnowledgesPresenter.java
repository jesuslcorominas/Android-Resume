package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.presenter.callbackview.KnowledgesView;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public interface KnowledgesPresenter extends Presenter<KnowledgesView> {

    void getKnowledges();

    ArrayList<Knowledge> getDatasource();
}
