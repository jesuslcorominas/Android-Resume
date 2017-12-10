package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.KnowledgesPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.KnowledgesView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class KnowledgesPresenterImpl extends AbstractPresenter<KnowledgesView> implements KnowledgesPresenter {

    private ArrayList<Knowledge> knowledges;

    private GetListUseCase<Knowledge> knowledgeListUseCase;

    public KnowledgesPresenterImpl(GetListUseCase<Knowledge> knowledgeListUseCase) {
        this.knowledgeListUseCase = knowledgeListUseCase;
    }

    @Override
    public void loadKnowledges() {
        // Si no hay datos ocultamos todas las vistas menos el progress
        if (resumed) {
            showProgressAndHideOthers();
        }

        knowledgeListUseCase.execute(null, new UseCase.Callback<List<Knowledge>>() {
            @Override
            public void onSuccess(List<Knowledge> data) {
                KnowledgesPresenterImpl.this.knowledges = new ArrayList<>();

                Collections.sort(data, new Knowledge.KnowledgesComparator());
                KnowledgesPresenterImpl.this.knowledges.addAll(data);
                if (resumed) {
                    showDataAndHideOthers();
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                if (resumed) {
                    callbackView.showErrorGettingData(error);
                    showNoDataAndHideOthers();
                }
            }
        });
    }

    @Override
    public ArrayList<Knowledge> getKnowledges() {
        return knowledges;
    }
}
