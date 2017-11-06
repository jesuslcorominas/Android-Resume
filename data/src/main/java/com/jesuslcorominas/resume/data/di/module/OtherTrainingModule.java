package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.impl.OtherTrainingDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.OtherTrainingDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.OtherTrainingDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.OtherTraining;
import com.jesuslcorominas.resume.data.net.OtherTrainingRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.OtherTrainingRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.OtherTrainingRepositoryImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class})
public class OtherTrainingModule {

    @Provides
    @Singleton
    Box<OtherTraining> provideBox(BoxStore boxStore) {
        return boxStore.boxFor(OtherTraining.class);
    }

    @Provides
    Dao<OtherTraining> provideDao(Box<OtherTraining> box) {
        return new OtherTrainingDao(box);
    }

    @Provides
    @Named("local")
    Datasource<OtherTraining> provideDatasourceLocal(Dao<OtherTraining> dao) {
        return new OtherTrainingDatasourceLocalImpl(dao);
    }

    @Provides
    OtherTrainingRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(OtherTrainingRestClient.Api.class);
    }

    @Provides
    RestClient<OtherTraining> provideRestClient(OtherTrainingRestClient.Api api) {
        return new OtherTrainingRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<OtherTraining> provideDatasourceRemote(RestClient<OtherTraining> restClient) {
        return new OtherTrainingDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<OtherTraining> provideRepository(@Named("local") Datasource<OtherTraining> localDatasource, @Named("remote") Datasource<OtherTraining> remoteDatasource) {
        return new OtherTrainingRepositoryImpl(localDatasource, remoteDatasource);
    }
}

