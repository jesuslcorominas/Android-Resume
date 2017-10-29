package com.jesuslcorominas.resume.data.net;

import com.jesuslcorominas.resume.data.entity.Language;
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
public interface LanguageRestClient extends RestClient<Language> {

    interface Api {
        @GET(WebServicesKeys.Paths.language)
        Call<ServerResponse<List<Language>>> list();

        @GET(WebServicesKeys.Paths.language)
        Call<ServerResponse<List<Language>>> refresh(@Query(WebServicesKeys.Fields.lastUpdated) String date);

        @GET(WebServicesKeys.Paths.languageDetail)
        Call<ServerResponse<Language>> detail(@Path(WebServicesKeys.Fields.id) long itemId);
    }
}
