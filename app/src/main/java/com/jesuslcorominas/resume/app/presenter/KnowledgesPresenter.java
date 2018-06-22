package com.jesuslcorominas.resume.app.presenter;

import com.jesuslcorominas.resume.app.view.callbackview.KnowledgesView;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface KnowledgesPresenter extends Presenter<KnowledgesView> {

    void loadKnowledges();

    List<Knowledge> getKnowledges();
}
