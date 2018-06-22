package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.datasource.TrainingDatasource;
import com.jesuslcorominas.resume.data.repository.impl.ExperienceRepositoryImpl;
import com.jesuslcorominas.resume.data.repository.impl.KnowledgeRepositoryImpl;
import com.jesuslcorominas.resume.data.repository.impl.OtherDataRepositoryImpl;
import com.jesuslcorominas.resume.data.repository.impl.PersonalDataRepositoryImpl;
import com.jesuslcorominas.resume.data.repository.impl.TrainingRepositoryImpl;
import com.jesuslcorominas.resume.model.repository.ExperienceRepository;
import com.jesuslcorominas.resume.model.repository.KnowledgeRepository;
import com.jesuslcorominas.resume.model.repository.OtherDataRepository;
import com.jesuslcorominas.resume.model.repository.PersonalDataRepository;
import com.jesuslcorominas.resume.model.repository.TrainingRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {DatasourceModule.class})
public class RepositoryModule {

    @Provides
    TrainingRepository provideTrainingRepository(@Named("local") TrainingDatasource localDatasource, @Named("remote") TrainingDatasource remoteDatasource) {
        return new TrainingRepositoryImpl(localDatasource, remoteDatasource);
    }

    @Provides
    ExperienceRepository provideExperienceRepository(@Named("local") ExperienceDatasource localDatasource, @Named("remote") ExperienceDatasource remoteDatasource) {
        return new ExperienceRepositoryImpl(localDatasource, remoteDatasource);
    }

    @Provides
    KnowledgeRepository provideKnowledgeRepository(@Named("local") KnowledgeDatasource localDatasource, @Named("remote") KnowledgeDatasource remoteDatasource) {
        return new KnowledgeRepositoryImpl(localDatasource, remoteDatasource);
    }

    @Provides
    OtherDataRepository provideOtherDataRepository(@Named("local") OtherDataDatasource localDatasource, @Named("remote") OtherDataDatasource remoteDatasource) {
        return new OtherDataRepositoryImpl(localDatasource, remoteDatasource);
    }

    @Provides
    PersonalDataRepository providePersonalDataRepository(@Named("local") PersonalDataDatasource localDatasource, @Named("remote") PersonalDataDatasource remoteDatasource) {
        return new PersonalDataRepositoryImpl(localDatasource, remoteDatasource);
    }
}
