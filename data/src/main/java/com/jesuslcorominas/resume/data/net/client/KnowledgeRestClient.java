package com.jesuslcorominas.resume.data.net.client;

import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.net.dto.KnowledgeDto;
import com.jesuslcorominas.resume.data.net.util.ServerResponse;
import com.jesuslcorominas.resume.data.net.util.WebServicesKeys;

import org.joda.time.DateTime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jesús López Corominas
 */
public interface KnowledgeRestClient extends RestClient<Knowledge> {

    interface Api {
        @GET(WebServicesKeys.Paths.knowledge)
        Call<ServerResponse<List<KnowledgeDto>>> list(@Query(WebServicesKeys.QueriesParams.lastDate) DateTime lastDate);
    }
}
