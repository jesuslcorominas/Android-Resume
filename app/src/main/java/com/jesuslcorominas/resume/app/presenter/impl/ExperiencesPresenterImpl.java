package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.ExperiencesPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.ExperiencesView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ExperiencesPresenterImpl extends AbstractPresenter<ExperiencesView> implements ExperiencesPresenter {

    private ArrayList<Experience> experiences;

    private final GetListUseCase<Experience> experienceListUseCase;

    public ExperiencesPresenterImpl(GetListUseCase<Experience> experienceListUseCase) {
        this.experienceListUseCase = experienceListUseCase;
    }

    @Override
    public void loadExperiences() {
        // Si no hay datos ocultamos todas las vistas menos el progress
        if (resumed) {
            showProgressAndHideOthers();
        }

        experienceListUseCase.execute(null, new UseCase.Callback<List<Experience>>() {
            @Override
            public void onSuccess(List<Experience> data) {
                // TODO mirar a ver porque la primera vez queda mal ordenado
                ExperiencesPresenterImpl.this.experiences = new ArrayList<>();

                Collections.sort(data, new Experience.ExperiencesComparator());
                ExperiencesPresenterImpl.this.experiences.addAll(data);

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
    public ArrayList<Experience> getExperiences() {
        return experiences;
    }
}
