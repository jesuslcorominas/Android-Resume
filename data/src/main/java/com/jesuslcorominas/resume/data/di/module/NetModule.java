package com.jesuslcorominas.resume.data.di.module;

import com.google.gson.Gson;
import com.jesuslcorominas.resume.data.net.client.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.client.KnowledgeRestClient;
import com.jesuslcorominas.resume.data.net.client.OtherDataRestClient;
import com.jesuslcorominas.resume.data.net.client.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.client.TrainingRestClient;
import com.jesuslcorominas.resume.data.net.client.impl.ExperienceRestClientImpl;
import com.jesuslcorominas.resume.data.net.client.impl.KnowledgeRestClientImpl;
import com.jesuslcorominas.resume.data.net.client.impl.OtherDataRestClientImpl;
import com.jesuslcorominas.resume.data.net.client.impl.PersonalDataRestClientImpl;
import com.jesuslcorominas.resume.data.net.client.impl.TrainingRestClientImpl;

import org.modelmapper.ModelMapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {GsonModule.class, MapperModule.class})
@Singleton
public class NetModule {

    private static final int READ_TIMEOUT = 60;
    private static final int CONNECT_TIMEOUT = 5;

    private static NetModule instance;

    private String endPoint;

    private NetModule(String endPoint) {
        this.endPoint = endPoint;
    }

    public static NetModule getInstance(String endPoint) {
        if (instance == null) {
            instance = new NetModule(endPoint);
        }

        return instance;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).
                addInterceptor(interceptor).
                build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }

    @Provides
    TrainingRestClient.Api provideTrainingRestClientApi(Retrofit retrofit) {
        return retrofit.create(TrainingRestClient.Api.class);
    }

    @Provides
    TrainingRestClient provideTrainingRestClient(TrainingRestClient.Api api, ModelMapper mapper) {
        return new TrainingRestClientImpl(api, mapper);
    }

    @Provides
    ExperienceRestClient.Api provideExperienceRestClientApi(Retrofit retrofit) {
        return retrofit.create(ExperienceRestClient.Api.class);
    }

    @Provides
    ExperienceRestClient provideExperienceRestClient(ExperienceRestClient.Api api, ModelMapper mapper) {
        return new ExperienceRestClientImpl(api, mapper);
    }

    @Provides
    KnowledgeRestClient.Api provideKnowledgeRestClientApi(Retrofit retrofit) {
        return retrofit.create(KnowledgeRestClient.Api.class);
    }

    @Provides
    KnowledgeRestClient provideKnowledgeRestClient(KnowledgeRestClient.Api api, ModelMapper mapper) {
        return new KnowledgeRestClientImpl(api, mapper);
    }

    @Provides
    OtherDataRestClient.Api provideOtherDataRestClientApi(Retrofit retrofit) {
        return retrofit.create(OtherDataRestClient.Api.class);
    }

    @Provides
    OtherDataRestClient provideOtherDataRestClient(OtherDataRestClient.Api api, ModelMapper mapper) {
        return new OtherDataRestClientImpl(api, mapper);
    }

    @Provides
    PersonalDataRestClient.Api providePersonalDataRestClientApi(Retrofit retrofit) {
        return retrofit.create(PersonalDataRestClient.Api.class);
    }

    @Provides
    PersonalDataRestClient providePersonalDataRestClient(PersonalDataRestClient.Api api, ModelMapper mapper) {
        return new PersonalDataRestClientImpl(api, mapper);
    }
}
