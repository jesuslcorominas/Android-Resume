package com.jesuslcorominas.resume.data.net.client;

import com.jesuslcorominas.resume.commons.model.Training;
import com.jesuslcorominas.resume.data.net.dto.TrainingDto;
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
public interface TrainingRestClient extends RestClient<Training> {

    interface Api {
        @GET(WebServicesKeys.Paths.training)
        Call<ServerResponse<List<TrainingDto>>> list(@Query(WebServicesKeys.QueriesParams.lastDate) DateTime lastDate);

    }
}
