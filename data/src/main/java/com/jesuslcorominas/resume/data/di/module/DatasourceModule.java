package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.database.dao.PersonalDataDao;
import com.jesuslcorominas.resume.data.database.dao.TrainingDao;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.datasource.KnowledgeDatasource;
import com.jesuslcorominas.resume.data.datasource.OtherDataDatasource;
import com.jesuslcorominas.resume.data.datasource.PersonalDataDatasource;
import com.jesuslcorominas.resume.data.datasource.TrainingDatasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.ExperienceDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.local.KnowledgeDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.local.OtherDataDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.local.PersonalDataDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.local.TrainingDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.ExperienceDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.KnowledgeDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.OtherDataDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.PersonalDataDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.TrainingDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.net.client.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.client.KnowledgeRestClient;
import com.jesuslcorominas.resume.data.net.client.OtherDataRestClient;
import com.jesuslcorominas.resume.data.net.client.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.client.TrainingRestClient;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {DatabaseModule.class, NetModule.class})
public class DatasourceModule {

    @Provides
    @Named("local")
    TrainingDatasource provideTrainingDatasourceLocal(TrainingDao dao) {
        return new TrainingDatasourceLocalImpl(dao);
    }

    @Provides
    @Named("remote")
    TrainingDatasource provideTrainingDatasourceRemote(TrainingRestClient restClient) {
        return new TrainingDatasourceRemoteImpl(restClient);
    }

    @Provides
    @Named("local")
    ExperienceDatasource provideExperienceDatasourceLocal(ExperienceDao dao) {
        return new ExperienceDatasourceLocalImpl(dao);
    }

    @Provides
    @Named("remote")
    ExperienceDatasource provideExperienceDatasourceRemote(ExperienceRestClient restClient) {
        return new ExperienceDatasourceRemoteImpl(restClient);
    }

    @Provides
    @Named("local")
    KnowledgeDatasource provideKnowledgeDatasourceLocal(KnowledgeDao dao) {
        return new KnowledgeDatasourceLocalImpl(dao);
    }

    @Provides
    @Named("remote")
    KnowledgeDatasource provideKnowledgeDatasourceRemote(KnowledgeRestClient restClient) {
        return new KnowledgeDatasourceRemoteImpl(restClient);
    }

    @Provides
    @Named("local")
    OtherDataDatasource provideOtherDataDatasourceLocal(OtherDataDao dao) {
        return new OtherDataDatasourceLocalImpl(dao);
    }

    @Provides
    @Named("remote")
    OtherDataDatasource provideOtherDataDatasourceRemote(OtherDataRestClient restClient) {
        return new OtherDataDatasourceRemoteImpl(restClient);
    }

    @Provides
    @Named("local")
    PersonalDataDatasource providePersonalDataDatasourceLocal(PersonalDataDao dao) {
        return new PersonalDataDatasourceLocalImpl(dao);
    }

    @Provides
    @Named("remote")
    PersonalDataDatasource providePersonalDataDatasourceRemote(PersonalDataRestClient restClient) {
        return new PersonalDataDatasourceRemoteImpl(restClient);
    }
}
