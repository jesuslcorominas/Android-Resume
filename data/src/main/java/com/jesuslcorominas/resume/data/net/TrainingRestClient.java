package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.Training;
import com.jesuslcorominas.resume.data.net.utils.ServerResponse;
import com.jesuslcorominas.resume.data.net.utils.WebServicesKeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jesús López Corominas
 */
public interface TrainingRestClient extends RestClient<Training> {

    interface Api {
        @GET(WebServicesKeys.Paths.training)
        Call<ServerResponse<List<Training>>> list();

        @GET(WebServicesKeys.Paths.training)
        Call<ServerResponse<List<Training>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

    }
}
