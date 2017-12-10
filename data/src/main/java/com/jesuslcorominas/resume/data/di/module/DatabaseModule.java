package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.database.dao.TrainingDao;
import com.jesuslcorominas.resume.data.database.dao.impl.ExperienceDaoImpl;
import com.jesuslcorominas.resume.data.database.dao.impl.KnowledgeDaoImpl;
import com.jesuslcorominas.resume.data.database.dao.impl.OtherDataDaoImpl;
import com.jesuslcorominas.resume.data.database.dao.impl.PersonalDataDaoImpl;
import com.jesuslcorominas.resume.data.database.dao.impl.TrainingDaoImpl;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.entity.MyObjectBox;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.entity.Training;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
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

    @Provides
    Box<Training> provideTrainingBox(BoxStore boxStore) {
        return boxStore.boxFor(Training.class);
    }

    @Provides
    Box<Knowledge> provideKnowledgeBox(BoxStore boxStore) {
        return boxStore.boxFor(Knowledge.class);
    }

    @Provides
    Box<Experience> provideExperienceBox(BoxStore boxStore) {
        return boxStore.boxFor(Experience.class);
    }

    @Provides
    Box<OtherData> provideOtherDataBox(BoxStore boxStore) {
        return boxStore.boxFor(OtherData.class);
    }

    @Provides
    Box<PersonalData> providePersonalDataBox(BoxStore boxStore) {
        return boxStore.boxFor(PersonalData.class);
    }

    @Provides
    TrainingDao provideTrainingDao(Box<Training> box) {
        return new TrainingDaoImpl(box);
    }

    @Provides
    ExperienceDao provideExperienceDao(Box<Experience> box) {
        return new ExperienceDaoImpl(boxStore, box);
    }

    @Provides
    KnowledgeDao provideKnowledgeDao(Box<Knowledge> box) {
        return new KnowledgeDaoImpl(box);
    }

    @Provides
    OtherDataDao provideOtherDataDao(Box<OtherData> box) {
        return new OtherDataDaoImpl(box);
    }

    @Provides
    PersonalDataDao providePersonalDataDao(Box<PersonalData> box) {
        return new PersonalDataDaoImpl(box);
    }
}
