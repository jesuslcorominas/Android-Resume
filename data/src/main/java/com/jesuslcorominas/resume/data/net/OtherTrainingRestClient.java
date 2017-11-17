package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.OtherTraining;
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
public interface OtherTrainingRestClient extends RestClient <OtherTraining>{

    interface Api {
        @GET(WebServicesKeys.Paths.otherTraining)
        Call<ServerResponse<List<OtherTraining>>> list();

        @GET(WebServicesKeys.Paths.otherTraining)
        Call<ServerResponse<List<OtherTraining>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

    }
}
