package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.dao.Dao;
import com.jesuslcorominas.resume.data.database.dao.impl.PersonalDataDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.PersonalDataDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.PersonalDataDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.PersonalData;
import com.jesuslcorominas.resume.data.net.PersonalDataRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.PersonalDataRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.PersonalDataRepositoryImpl;

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
public class PersonalDataModule {

    @Provides
    Box<PersonalData> provideBox(BoxStore boxStore) {
        return boxStore.boxFor(PersonalData.class);
    }

    @Provides
    Dao<PersonalData> provideDao(Box<PersonalData> box) {
        return new PersonalDataDao(box);
    }

    @Provides
    @Named("local")
    Datasource<PersonalData> provideDatasourceLocal(Dao<PersonalData> dao) {
        return new PersonalDataDatasourceLocalImpl(dao);
    }

    @Provides
    PersonalDataRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(PersonalDataRestClient.Api.class);
    }

    @Provides
    RestClient<PersonalData> provideRestClient(PersonalDataRestClient.Api api) {
        return new PersonalDataRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<PersonalData> provideDatasourceRemote(RestClient<PersonalData> restClient) {
        return new PersonalDataDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<PersonalData> provideRepository(@Named("local") Datasource<PersonalData> localDatasource, @Named("remote") Datasource<PersonalData> remoteDatasource) {
        return new PersonalDataRepositoryImpl(localDatasource, remoteDatasource);
    }
}
