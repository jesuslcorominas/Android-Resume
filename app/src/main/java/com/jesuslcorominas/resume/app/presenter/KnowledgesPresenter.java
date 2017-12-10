package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.KnowledgesView;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public interface KnowledgesPresenter extends Presenter<KnowledgesView> {

    void loadKnowledges();

    ArrayList<Knowledge> getKnowledges();
}
