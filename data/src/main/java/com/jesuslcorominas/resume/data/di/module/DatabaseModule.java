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
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;
import com.jesuslcorominas.resume.data.entity.MyObjectBox;
import com.jesuslcorominas.resume.data.entity.OtherDataObjectBoxEntity;
import com.jesuslcorominas.resume.data.entity.PersonalDataObjectBoxEntity;
import com.jesuslcorominas.resume.data.entity.TrainingObjectBoxEntity;

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
    Box<TrainingObjectBoxEntity> provideTrainingBox(BoxStore boxStore) {
        return boxStore.boxFor(TrainingObjectBoxEntity.class);
    }

    @Provides
    Box<KnowledgeObjectBoxEntity> provideKnowledgeBox(BoxStore boxStore) {
        return boxStore.boxFor(KnowledgeObjectBoxEntity.class);
    }

    @Provides
    Box<ExperienceObjectBoxEntity> provideExperienceBox(BoxStore boxStore) {
        return boxStore.boxFor(ExperienceObjectBoxEntity.class);
    }

    @Provides
    Box<OtherDataObjectBoxEntity> provideOtherDataBox(BoxStore boxStore) {
        return boxStore.boxFor(OtherDataObjectBoxEntity.class);
    }

    @Provides
    Box<PersonalDataObjectBoxEntity> providePersonalDataBox(BoxStore boxStore) {
        return boxStore.boxFor(PersonalDataObjectBoxEntity.class);
    }

    @Provides
    TrainingDao provideTrainingDao(Box<TrainingObjectBoxEntity> box) {
        return new TrainingDaoImpl(box);
    }

    @Provides
    ExperienceDao provideExperienceDao(Box<ExperienceObjectBoxEntity> box) {
        return new ExperienceDaoImpl(boxStore, box);
    }

    @Provides
    KnowledgeDao provideKnowledgeDao(Box<KnowledgeObjectBoxEntity> box) {
        return new KnowledgeDaoImpl(box);
    }

    @Provides
    OtherDataDao provideOtherDataDao(Box<OtherDataObjectBoxEntity> box) {
        return new OtherDataDaoImpl(box);
    }

    @Provides
    PersonalDataDao providePersonalDataDao(Box<PersonalDataObjectBoxEntity> box) {
        return new PersonalDataDaoImpl(box);
    }
}
