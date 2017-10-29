package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.BoxFactory;
import com.jesuslcorominas.resume.data.entity.MyObjectBox;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    BoxStore provideBoxStore(File baseDirectory) {
        return MyObjectBox.builder().baseDirectory(baseDirectory).build();
    }

    @Singleton
    @Provides
    BoxFactory provideBoxFactory(BoxStore boxStore) {
        return new BoxFactory(boxStore);
    }

}
