package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.model.repository.Repository;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractRepository<T> implements Repository<T> {

    private final Datasource<T> localDatasource;
    private final Datasource<T> remoteDatasource;

    AbstractRepository(Datasource<T> localDatasource, Datasource<T> remoteDatasource) {
        this.localDatasource = localDatasource;
        this.remoteDatasource = remoteDatasource;
    }

    @Override
    public void list(DateTime lastDate, final GetCallback<List<T>> callback) {
        remoteDatasource.list(new GetCallback<List<T>>() {
            @Override
            public void onSuccess(List<T> result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });

        // TODO implementar de verdad con la fecha de peticion
//        localDatasource.list(new GetCallback<List<T>>() {
//            @Override
//            public void onSuccess(List<T> data) {
//                if (data != null && data.size() > 0) {
//                    callback.onSuccess(data);
//                } else {
//                    remoteDatasource.list(new GetCallback<List<T>>() {
//                        @Override
//                        public void onSuccess(List<T> data) {
//                            localDatasource.save(data, new GetCallback<List<T>>() {
//                                @Override
//                                public void onSuccess(List<T> data) {
//                                    callback.onSuccess(data);
//                                }
//
//                                @Override
//                                public void onError(ErrorInfo error) {
//                                    callback.onError(error);
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onError(ErrorInfo error) {
//                            callback.onError(error);
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onError(ErrorInfo error) {
//                callback.onError(error);
//            }
//        });
    }
}
