package com.jesuslcorominas.resume.model.usecase;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface ExperienceRefreshListUseCase extends UseCase<DateTime, List<Experience>> {

}
