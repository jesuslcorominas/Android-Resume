package com.jesuslcorominas.resume.model.usecase.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.model.usecase.ExperienceListUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class ExperienceListUseCaseImpl implements ExperienceListUseCase {

    private Repository<Experience> experienceRepository;

    @Inject
    public ExperienceListUseCaseImpl(Repository<Experience> experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public void execute(Void inputData, final Callback<List<Experience>> callback) {
        experienceRepository.list(new Repository.ListCallback<Experience>() {
            @Override
            public void onSuccess(List<Experience> data) {
                if (data == null || data.size() == 0) {
                    callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No se ha encontrado ningún elemento"));
                    return;
                }

                callback.onSuccess(data);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }
}
