package com.jesuslcorominas.resume.data.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.entity.Position;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
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
@Module
public class NetModule {

    private static final int READ_TIMEOUT = 60;
    private static final int CONNECT_TIMEOUT = 5;

    @Singleton
    @Provides
    Gson provideGson(JsonSerializer<DateTime> dateTimeJsonSerializer, JsonDeserializer<DateTime> dateTimeJsonDeserializer,
                     JsonSerializer<Position> positionJsonSerializer, JsonDeserializer<Position> positionJsonDeserializer) {
        return new GsonBuilder().
                serializeNulls().
                setPrettyPrinting().
                registerTypeAdapter(DateTime.class, dateTimeJsonDeserializer).
                registerTypeAdapter(DateTime.class, dateTimeJsonSerializer).
                registerTypeAdapter(Position.class, positionJsonDeserializer).
                registerTypeAdapter(Position.class, positionJsonSerializer).
                create();
    }

    @Singleton
    @Provides
    JsonSerializer<DateTime> provideDateTimeJsonSerializer() {
        return new JsonSerializer<DateTime>() {
            @Override
            public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.toString(Keys.Miscellany.internalDateFormatter));
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<DateTime> provideDateTimeJsonDeserializer() {
        return new JsonDeserializer<DateTime>() {
            @Override
            public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return DateTime.parse(json.getAsString(), DateTimeFormat.forPattern(Keys.Miscellany.internalDateFormatter));
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<Position> providePositionJsonDeserializer() {
        return new JsonDeserializer<Position>() {
            @Override
            public Position deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return Position.getPosition(json.getAsInt());
            }
        };
    }

    @Singleton
    @Provides
    JsonSerializer<Position> providePositionJsonSerializer() {
        return new JsonSerializer<Position>() {
            @Override
            public JsonElement serialize(Position src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getValue());
            }
        };
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
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson, @Named("baseUrl") String baseUrl) {
        return new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }
}
