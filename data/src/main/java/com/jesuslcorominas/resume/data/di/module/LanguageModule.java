package com.jesuslcorominas.resume.data.di.module;

import com.jesuslcorominas.resume.data.database.BoxFactory;
import com.jesuslcorominas.resume.data.database.Dao;
import com.jesuslcorominas.resume.data.database.dao.LanguageDao;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.datasource.impl.local.LanguageDatasourceLocalImpl;
import com.jesuslcorominas.resume.data.datasource.impl.remote.LanguageDatasourceRemoteImpl;
import com.jesuslcorominas.resume.data.entity.Language;
import com.jesuslcorominas.resume.data.net.LanguageRestClient;
import com.jesuslcorominas.resume.data.net.RestClient;
import com.jesuslcorominas.resume.data.net.impl.LanguageRestClientImpl;
import com.jesuslcorominas.resume.data.repository.Repository;
import com.jesuslcorominas.resume.data.repository.impl.LanguageRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import retrofit2.Retrofit;

/**
 * @author Jesús López Corominas
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class LanguageModule {

    @Provides
    Box<Language> provideBox(BoxFactory factory) {
        return factory.getBoxStore().boxFor(Language.class);
    }

    @Provides
    Dao<Language> provideDao(Box<Language> box) {
        return new LanguageDao(box);
    }

    @Provides
    @Named("local")
    Datasource<Language> provideDatasourceLocal(Dao<Language> dao) {
        return new LanguageDatasourceLocalImpl(dao);
    }

    @Provides
    LanguageRestClient.Api provideRestClientApi(Retrofit retrofit) {
        return retrofit.create(LanguageRestClient.Api.class);
    }

    @Provides
    RestClient<Language> provideRestClient(LanguageRestClient.Api api) {
        return new LanguageRestClientImpl(api);
    }

    @Provides
    @Named("remote")
    Datasource<Language> provideDatasourceRemote(RestClient<Language> restClient) {
        return new LanguageDatasourceRemoteImpl(restClient);
    }

    @Provides
    Repository<Language> provideRepository(@Named("local") Datasource<Language> localDatasource, @Named("remote") Datasource<Language> remoteDatasource) {
        return new LanguageRepositoryImpl(localDatasource, remoteDatasource);
    }
}
