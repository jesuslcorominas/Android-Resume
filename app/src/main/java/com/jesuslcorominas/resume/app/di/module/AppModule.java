package com.jesuslcorominas.resume.app.di.module;

import android.content.Context;

import com.jesuslcorominas.resume.app.BuildConfig;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    File provideBaseDirectory(Context context) {
        return context.getFilesDir();
    }

    @Named("baseUrl")
    @Provides
    @Singleton
    String provideBaseUrl() {
        return BuildConfig.END_POINT + BuildConfig.URL_WS;
    }
}
