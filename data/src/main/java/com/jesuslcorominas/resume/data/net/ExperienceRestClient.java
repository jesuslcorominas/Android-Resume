package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.utils.ServerResponse;
import com.jesuslcorominas.resume.data.net.utils.WebServicesKeys;

import org.joda.time.DateTime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Jesús López Corominas
 */
public interface ExperienceRestClient extends RestClient<Experience> {

    interface Api {
        @GET(WebServicesKeys.Paths.experience)
        Call<ServerResponse<List<Experience>>> list();

        @GET(WebServicesKeys.Paths.experience)
        Call<ServerResponse<List<Experience>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) DateTime date);

        @GET(WebServicesKeys.Paths.experienceDetail)
        Call<ServerResponse<Experience>> detail(@Path(WebServicesKeys.Fields.id) long itemId);
    }
}
