package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.BoxFactory;
import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.KnowledgeDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.KnowledgeDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.KnowledgeDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.net.KnowledgeRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.KnowledgeRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.KnowledgeRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class KnowledgeModule {

    @Provides
    Box<Knowledge> provideBox(BoxFactory factory) {
        return factory.getBoxStore().boxFor(Knowledge.class);
    }

    @Provides
    Dao<Knowledge> provideDao(Box<Knowledge> box) {
        return new KnowledgeDao(box);
    }

    @Provides
    @Named("local")
    Datasource<Knowledge> provideDatasourceLocal(Dao<Knowledge> dao) {
        return new KnowledgeDatasourceLocalImpl(dao);
    }

    @Provides
    KnowledgeRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(KnowledgeRestClient.Api.class);
    }

    @Provides
    RestClient<Knowledge> provideRestClient(Retrofit retrofit, KnowledgeRestClient.Api api) {
        return new KnowledgeRestClientImpl(retrofit, api);
    }

    @Provides
    @Named("remote")
    Datasource<Knowledge> provideDatasourceRemote(RestClient<Knowledge> restClient) {
        return new KnowledgeDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<Knowledge> provideRepository(@Named("local") Datasource<Knowledge> localDatasource, @Named("remote") Datasource<Knowledge> remoteDatasource) {
        return new KnowledgeRepositoryImpl(localDatasource, remoteDatasource);
    }
}
