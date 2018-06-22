package com.jesuslcorominas.resume.model.repository;

import com.jesuslcorominas.resume.commons.GetCallback;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface Repository<T> {

    void list(DateTime lastDate, GetCallback<List<T>> callback);

}
