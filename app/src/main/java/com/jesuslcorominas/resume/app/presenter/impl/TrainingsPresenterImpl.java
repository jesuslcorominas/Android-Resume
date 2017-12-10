package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.TrainingsPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.TrainingsView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.Training;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class TrainingsPresenterImpl extends AbstractPresenter<TrainingsView> implements TrainingsPresenter {

    private ArrayList<Training> trainings;

    private final GetListUseCase<Training> trainingListUseCase;

    public TrainingsPresenterImpl(GetListUseCase<Training> trainingListUseCase) {
        this.trainingListUseCase = trainingListUseCase;
    }

    @Override
    public void loadTrainings() {
        // Si no hay datos ocultamos todas las vistas menos el progress
        if (resumed) {
            showProgressAndHideOthers();
        }

        trainingListUseCase.execute(null, new UseCase.Callback<List<Training>>() {
            @Override
            public void onSuccess(List<Training> data) {
                TrainingsPresenterImpl.this.trainings = new ArrayList<>();

                Collections.sort(data, new Training.TrainingComparator());
                TrainingsPresenterImpl.this.trainings.addAll(data);
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
    public ArrayList<Training> getTrainings() {
        return trainings;
    }
}
