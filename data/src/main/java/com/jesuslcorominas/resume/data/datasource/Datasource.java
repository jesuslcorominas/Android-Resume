package com.jesuslcorominas.resume.data.datasource;

import com.jesuslcorominas.resume.commons.GetCallback;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface Datasource<T> {

    void list(GetCallback<List<T>> callback);

    void save(List<T> items, GetCallback<List<T>> callback);

}
