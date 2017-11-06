package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.impl.ExperienceDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.ExperienceDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.ExperienceDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.ExperienceRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.ExperienceRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class})
public class ExperienceModule {

    @Provides
    Box<Experience> provideBox(BoxStore boxStore) {
        return boxStore.boxFor(Experience.class);
    }

    @Provides
    Dao<Experience> provideDao(Box<Experience> box) {
        return new ExperienceDao(box);
    }

    @Provides
    @Named("local")
    Datasource<Experience> provideDatasourceLocal(Dao<Experience> dao) {
        return new ExperienceDatasourceLocalImpl(dao);
    }

    @Provides
    ExperienceRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(ExperienceRestClient.Api.class);
    }

    @Provides
    RestClient<Experience> provideRestClient(ExperienceRestClient.Api api) {
        return new ExperienceRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<Experience> provideDatasourceRemote(RestClient<Experience> restClient) {
        return new ExperienceDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<Experience> provideRepository(@Named("local") Datasource<Experience> localDatasource, @Named("remote") Datasource<Experience> remoteDatasource) {
        return new ExperienceRepositoryImpl(localDatasource, remoteDatasource);
    }
}
