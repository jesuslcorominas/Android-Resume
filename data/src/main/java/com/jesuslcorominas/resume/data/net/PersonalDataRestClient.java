package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.PersonalData;
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
public interface PersonalDataRestClient extends RestClient<PersonalData> {

    interface Api {
        @GET(WebServicesKeys.Paths.personalData)
        Call<ServerResponse<List<PersonalData>>> list();

        @GET(WebServicesKeys.Paths.personalData)
        Call<ServerResponse<List<PersonalData>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

        @GET(WebServicesKeys.Paths.personalDataDetail)
        Call<ServerResponse<PersonalData>> detail(@Path(WebServicesKeys.Fields.id) long itemId);
    }
}
