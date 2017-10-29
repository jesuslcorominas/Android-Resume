package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.OtherData;
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
public interface OtherDataRestClient extends RestClient<OtherData> {

    interface Api {
        @GET(WebServicesKeys.Paths.otherData)
        Call<ServerResponse<List<OtherData>>> list();

        @GET(WebServicesKeys.Paths.otherData)
        Call<ServerResponse<List<OtherData>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

        @GET(WebServicesKeys.Paths.otherDataDetail)
        Call<ServerResponse<OtherData>> detail(@Path(WebServicesKeys.Fields.id) long itemId);
    }
}
