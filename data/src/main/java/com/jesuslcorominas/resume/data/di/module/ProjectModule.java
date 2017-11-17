package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.impl.ProjectDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.ProjectDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.ProjectDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.Project;
import com.jesuslcorominas.resume.data.net.ProjectRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.ProjectRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.ProjectRepositoryImpl;

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
public class ProjectModule {

    @Provides
    Box<Project> provideBox(BoxStore boxStore) {
        return boxStore.boxFor(Project.class);
    }

    @Provides
    Dao<Project> provideDao(Box<Project> box) {
        return new ProjectDao(box);
    }

    @Provides
    @Named("local")
    Datasource<Project> provideDatasourceLocal(Dao<Project> dao) {
        return new ProjectDatasourceLocalImpl(dao);
    }

    @Provides
    ProjectRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(ProjectRestClient.Api.class);
    }

    @Provides
    RestClient<Project> provideRestClient(ProjectRestClient.Api api) {
        return new ProjectRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<Project> provideDatasourceRemote(RestClient<Project> restClient) {
        return new ProjectDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<Project> provideRepository(@Named("local") Datasource<Project> localDatasource, @Named("remote") Datasource<Project> remoteDatasource) {
        return new ProjectRepositoryImpl(localDatasource, remoteDatasource);
    }
}
