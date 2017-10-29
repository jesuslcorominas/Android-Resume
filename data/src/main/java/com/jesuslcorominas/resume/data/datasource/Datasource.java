package com.jesuslcorominas.resume.data.datasource;

import com.jesuslcorominas.resume.commons.GenericCallback;

import org.joda.time.DateTime;

import java.util.List;

import javax.sql.DataSource;

/**
 * @author Jesús López Corominas
 */
public interface Datasource<T> {

    void refresh(DateTime dateTime, Datasource.ListCallback<T> callback);

    void list(Datasource.ListCallback<T> callback);

    void save(T item, Datasource.SaveCallback<T> callback);

    void save(List<T> items, Datasource.SaveListCallback<T> callback);

    void detail(long itemId, Datasource.DetailCallback<T> callback);

    interface ListCallback<T> extends GenericCallback<List<T>> {
    }

    interface DetailCallback<T> extends GenericCallback<T> {
    }

    interface SaveCallback<T> extends GenericCallback<T> {
    }

    interface SaveListCallback<T> extends GenericCallback<List<T>> {
    }
}
