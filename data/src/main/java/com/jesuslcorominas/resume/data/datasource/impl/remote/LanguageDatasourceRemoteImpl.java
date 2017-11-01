package com.jesuslcorominas.resume.data.datasource.impl.remote;

import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.net.LanguageRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Jesús López Corominas
 */
public class LanguageDatasourceRemoteImpl extends AbstractDatasourceRemoteImpl<Language> {

    @Inject
    public LanguageDatasourceRemoteImpl(RestClient<Language> restClient) {
        super(restClient);
    }
}
