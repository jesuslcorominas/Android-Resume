package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.commons.GenericCallback;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface RestClient<T> {

    void list(RestClient.ListCallback<T> callback);

    void detail(long itemId, RestClient.DetailCallback<T> callback);

    void refresh(DateTime date, RestClient.ListCallback<T> callback);

    interface ListCallback<T> extends GenericCallback<List<T>> {
    }

    interface DetailCallback<T> extends GenericCallback<T> {
    }
}
