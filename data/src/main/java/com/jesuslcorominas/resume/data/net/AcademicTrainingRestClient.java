package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.AcademicTraining;
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
public interface AcademicTrainingRestClient extends RestClient<AcademicTraining> {

    interface Api {
        @GET(WebServicesKeys.Paths.academicTraining)
        Call<ServerResponse<List<AcademicTraining>>> list();

        @GET(WebServicesKeys.Paths.academicTraining)
        Call<ServerResponse<List<AcademicTraining>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

        @GET(WebServicesKeys.Paths.academicTrainingDetail)
        Call<ServerResponse<AcademicTraining>> detail(@Path(WebServicesKeys.Fields.id) long itemId);
    }
}
