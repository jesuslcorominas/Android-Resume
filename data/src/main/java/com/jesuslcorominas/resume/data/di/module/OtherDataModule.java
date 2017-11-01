package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.BoxFactory;
import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.OtherDataDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.OtherDataDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.data.net.OtherDataRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.OtherDataRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.OtherDataRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class OtherDataModule {

    @Provides
    Box<OtherData> provideBox(BoxFactory factory) {
        return factory.getBoxStore().boxFor(OtherData.class);
    }

    @Provides
    Dao<OtherData> provideDao(Box<OtherData> box) {
        return new OtherDataDao(box);
    }

    @Provides
    @Named("local")
    Datasource<OtherData> provideDatasourceLocal(Dao<OtherData> dao) {
        return new OtherDataDatasourceLocalImpl(dao);
    }

    @Provides
    OtherDataRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(OtherDataRestClient.Api.class);
    }

    @Provides
    RestClient<OtherData> provideRestClient(OtherDataRestClient.Api api) {
        return new OtherDataRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<OtherData> provideDatasourceRemote(RestClient<OtherData> restClient) {
        return new OtherDataDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<OtherData> provideRepository(@Named("local") Datasource<OtherData> localDatasource, @Named("remote") Datasource<OtherData> remoteDatasource) {
        return new OtherDataRepositoryImpl(localDatasource, remoteDatasource);
    }
}

