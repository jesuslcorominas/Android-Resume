package com.jesuslcorominas.resume.data.repository;

import com.jesuslcorominas.resume.commons.GenericCallback;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface Repository<T> {

    void detail(long itemId, DetailCallback<T> callback);

    void refresh(DateTime dateTime, ListCallback<T> callback);

    void list(ListCallback<T> callback);

    interface DetailCallback<T> extends GenericCallback<T> {
    }

    interface ListCallback<T> extends GenericCallback<List<T>> {
    }

}
