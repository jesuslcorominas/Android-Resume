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
import com.jesuslcorominas.resume.data.entity.KnowledgeLevel;
import com.jesuslcorominas.resume.data.entity.KnowledgeType;
import com.jesuslcorominas.resume.data.entity.Platform;
import com.jesuslcorominas.resume.data.entity.Position;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Type;
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
@Module
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
    Gson provideGson(JsonSerializer<DateTime> dateTimeJsonSerializer, JsonDeserializer<DateTime> dateTimeJsonDeserializer,
                     JsonSerializer<Position> positionJsonSerializer, JsonDeserializer<Position> positionJsonDeserializer,
                     JsonSerializer<KnowledgeType> knowledgeTypeJsonSerializer, JsonDeserializer<KnowledgeType> knowledgeTypeJsonDeserializer,
                     JsonSerializer<KnowledgeLevel> knowledgeLevelJsonSerializer, JsonDeserializer<KnowledgeLevel> knowledgeLevelJsonDeserializer,
                     JsonSerializer<Platform> platformJsonSerializer, JsonDeserializer<Platform> platformJsonDeserializer) {
        return new GsonBuilder().
                serializeNulls().
                setPrettyPrinting().
                registerTypeAdapter(DateTime.class, dateTimeJsonDeserializer).
                registerTypeAdapter(DateTime.class, dateTimeJsonSerializer).
                registerTypeAdapter(Position.class, positionJsonDeserializer).
                registerTypeAdapter(Position.class, positionJsonSerializer).
                registerTypeAdapter(KnowledgeType.class, knowledgeTypeJsonDeserializer).
                registerTypeAdapter(KnowledgeType.class, knowledgeTypeJsonSerializer).
                registerTypeAdapter(KnowledgeLevel.class, knowledgeLevelJsonDeserializer).
                registerTypeAdapter(KnowledgeLevel.class, knowledgeLevelJsonSerializer).
                registerTypeAdapter(Platform.class, platformJsonDeserializer).
                registerTypeAdapter(Platform.class, platformJsonSerializer).
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
    JsonDeserializer<KnowledgeType> provideKnowledgeTypeJsonDeserializer() {
        return new JsonDeserializer<KnowledgeType>() {
            @Override
            public KnowledgeType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return KnowledgeType.getKnowledgeType(json.getAsInt());
            }
        };
    }

    @Singleton
    @Provides
    JsonSerializer<KnowledgeType> provideKnowledgeTypeJsonSerializer() {
        return new JsonSerializer<KnowledgeType>() {
            @Override
            public JsonElement serialize(KnowledgeType src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getValue());
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<KnowledgeLevel> provideKnowledgeLevelJsonDeserializer() {
        return new JsonDeserializer<KnowledgeLevel>() {
            @Override
            public KnowledgeLevel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return KnowledgeLevel.getKnowledgeLevel(json.getAsInt());
            }
        };
    }

    @Singleton
    @Provides
    JsonSerializer<KnowledgeLevel> provideKnowledgeLevelJsonSerializer() {
        return new JsonSerializer<KnowledgeLevel>() {
            @Override
            public JsonElement serialize(KnowledgeLevel src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getValue());
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<Platform> providePlatformJsonDeserializer() {
        return new JsonDeserializer<Platform>() {
            @Override
            public Platform deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return Platform.getPlatform(json.getAsInt());
            }
        };
    }

    @Singleton
    @Provides
    JsonSerializer<Platform> providePlatformJsonSerializer() {
        return new JsonSerializer<Platform>() {
            @Override
            public JsonElement serialize(Platform src, Type typeOfSrc, JsonSerializationContext context) {
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
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }
}
