package com.jesuslcorominas.resume.data.datasource.impl.local;

import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.entity.Experience;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDatasourceLocalImpl implements ExperienceDatasource {

    private ExperienceDao experienceDao;

    public ExperienceDatasourceLocalImpl(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public void list(Datasource.ListCallback<Experience> callback) {
        callback.onSuccess(experienceDao.getAll());
    }

    @Override
    public void refresh(DateTime dateTime, ListCallback<Experience> callback) {

    }

    @Override
    public void save(Experience item, SaveCallback<Experience> callback) {

    }

    @Override
    public void save(List<Experience> items, SaveListCallback<Experience> callback) {
        callback.onSuccess(experienceDao.save(items));
    }

    @Override
    public void detail(long itemId, Datasource.DetailCallback<Experience> callback) {

    }
}
