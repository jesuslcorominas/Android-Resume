package com.jesuslcorominas.resume.app.di.module;

import android.content.Context;

import com.jesuslcorominas.resume.app.BuildConfig;
import com.jesuslcorominas.resume.data.di.module.NetModule;
import com.jesuslcorominas.resume.data.entity.MyObjectBox;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Module
public class AppModule {

    private final Context context;

    private BoxStore boxStore;

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

    @Provides
    @Singleton
    BoxStore provideBoxStore(File baseDirectory) {
        if (boxStore == null) {
            boxStore = MyObjectBox.builder().baseDirectory(baseDirectory).build();
        }

        return boxStore;
    }
}
