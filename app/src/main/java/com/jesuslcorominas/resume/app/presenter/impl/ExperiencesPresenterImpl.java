package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.ExperiencesView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ExperiencesPresenterImpl extends AbstractPresenter<ExperiencesView> implements ExperiencesPresenter {

    private ArrayList<Experience> experiences;

    private final ListUseCase<Experience> experienceListUseCase;

    public ExperiencesPresenterImpl(ListUseCase<Experience> experienceListUseCase) {
        this.experienceListUseCase = experienceListUseCase;
    }

    @Override
    public void getExperiences() {
        // Si no hay datos ocultamos todas las vistas menos el progress
        showProgressAndHideOthers();

        experienceListUseCase.execute(null, new UseCase.Callback<List<Experience>>() {
            @Override
            public void onSuccess(List<Experience> data) {
                ExperiencesPresenterImpl.this.experiences = new ArrayList<>();

                Collections.sort(data, new Experience.ExperiencesComparator());
                ExperiencesPresenterImpl.this.experiences.addAll(data);

                showDataAndHideOthers();
            }

            @Override
            public void onError(ErrorInfo error) {
                callbackView.showErrorGettingData(error);
                showNoDataAndHideOthers();
            }
        });
    }

    @Override
    public ArrayList<Experience> getDatasource() {
        return experiences;
    }
}
