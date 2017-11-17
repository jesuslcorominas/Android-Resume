package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.utils.ServerResponse;
import com.jesuslcorominas.resume.data.net.utils.WebServicesKeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Jesús López Corominas
 */
public interface KnowledgeRestClient extends RestClient<Knowledge> {

    interface Api {
        @GET(WebServicesKeys.Paths.knowledge)
        Call<ServerResponse<List<Knowledge>>> list();

        @GET(WebServicesKeys.Paths.knowledge)
        Call<ServerResponse<List<Knowledge>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

    }
}
