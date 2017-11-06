package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.entity.MyObjectBox;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
@Singleton
@Module
public class DatabaseModule {

    private static DatabaseModule instance;

    BoxStore boxStore;

    private DatabaseModule(File baseDirectory) {
        boxStore = MyObjectBox.builder().baseDirectory(baseDirectory).build();
    }

    public static DatabaseModule getInstance(File baseDirectory) {
        if (instance == null) {
            instance = new DatabaseModule(baseDirectory);
        }

        return instance;
    }

    @Provides
    @Singleton
    BoxStore provideBoxStore() {
        return boxStore;
    }
}
