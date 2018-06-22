package com.jesuslcorominas.resume.data.net.client;

import com.jesuslcorominas.resume.commons.GenericCallback;
import com.jesuslcorominas.resume.commons.GetCallback;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface RestClient<VO> {

    void list(DateTime lastDate, GetCallback<List<VO>> callback);

}
