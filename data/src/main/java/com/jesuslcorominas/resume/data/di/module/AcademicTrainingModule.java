package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.impl.AcademicTrainingDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.AcademicTrainingDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.AcademicTrainingDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.AcademicTraining;
import com.jesuslcorominas.resume.data.net.AcademicTrainingRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.AcademicTrainingRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.AcademicTrainingRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class AcademicTrainingModule {

    @Provides
    Box<AcademicTraining> provideBox(BoxStore boxStore) {
        return boxStore.boxFor(AcademicTraining.class);
    }

    @Provides
    Dao<AcademicTraining> provideDao(Box<AcademicTraining> box) {
        return new AcademicTrainingDao(box);
    }

    @Provides
    @Named("local")
    Datasource<AcademicTraining> provideDatasourceLocal(Dao<AcademicTraining> dao) {
        return new AcademicTrainingDatasourceLocalImpl(dao);
    }

    @Provides
    AcademicTrainingRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(AcademicTrainingRestClient.Api.class);
    }

    @Provides
    RestClient<AcademicTraining> provideRestClient(AcademicTrainingRestClient.Api api) {
        return new AcademicTrainingRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<AcademicTraining> provideDatasourceRemote(RestClient<AcademicTraining> restClient) {
        return new AcademicTrainingDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<AcademicTraining> provideRepository(@Named("local") Datasource<AcademicTraining> localDatasource, @Named("remote") Datasource<AcademicTraining> remoteDatasource) {
        return new AcademicTrainingRepositoryImpl(localDatasource, remoteDatasource);
    }
}
