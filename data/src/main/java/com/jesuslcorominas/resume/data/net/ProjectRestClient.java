package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.Project;
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
public interface ProjectRestClient extends RestClient<Project> {

    interface Api {
        @GET(WebServicesKeys.Paths.project)
        Call<ServerResponse<List<Project>>> list();

        @GET(WebServicesKeys.Paths.project)
        Call<ServerResponse<List<Project>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

    }
}
