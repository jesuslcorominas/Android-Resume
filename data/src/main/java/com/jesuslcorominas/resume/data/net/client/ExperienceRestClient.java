package com.jesuslcorominas.resume.data.net.client;

import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.net.dto.ExperienceDto;
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
public interface ExperienceRestClient extends RestClient<Experience> {

    interface Api {
        @GET(WebServicesKeys.Paths.experience)
        Call<ServerResponse<List<ExperienceDto>>> list(@Query(WebServicesKeys.QueriesParams.lastDate) DateTime lastDate);

    }
}
