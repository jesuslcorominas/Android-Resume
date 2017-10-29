package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.BoxFactory;
import com.jesuslcorominas.resume.data.database.dao.ExperienceDao;
import com.jesuslcorominas.resume.data.datasource.ExperienceDatasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.ExperienceDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.ExperienceDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.jesuslcorominas.resume.data.net.ExperienceRestClient;
import com.jesuslcorominas.resume.data.net.impl.ExperienceRestClientImpl;
import com.jesuslcorominas.resume.data.repository.ExperienceRepository;
import com.jesuslcorominas.resume.data.repository.impl.ExperienceRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class ExperienceModule {

    @Provides
    ExperienceRepository provideExperienceRepository(@Named("local") ExperienceDatasource localDatasource, @Named("remote") ExperienceDatasource remoteDatasource) {
        return new ExperienceRepositoryImpl(localDatasource, remoteDatasource);
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
    ExperienceDao provideExperienceDao(Box<Experience> box) {
        return new ExperienceDao(box);
    }

    @Provides
    ExperienceRestClient provideExperienceRestClient(Retrofit retrofit, ExperienceRestClient.Api api) {
        return new ExperienceRestClientImpl(retrofit, api);
    }

    @Provides
    ExperienceRestClient.Api provideExperienceRestClientApi(Retrofit retrofit) {
        return retrofit.create(ExperienceRestClient.Api.class);
    }

    @Provides
    Box<Experience> provideExperienceBox(BoxFactory factory) {
        return factory.getBoxStore().boxFor(Experience.class);
    }
}
