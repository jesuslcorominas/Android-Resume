package com.jesuslcorominas.resume.data.repository.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.datasource.Datasource;
import com.jesuslcorominas.resume.data.repository.Repository;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
abstract class AbstractRepository<T> implements Repository<T> {

    private Datasource<T> localDatasource;
    private Datasource<T> remoteDatasource;

    AbstractRepository(Datasource<T> localDatasource, Datasource<T> remoteDatasource) {
        this.localDatasource = localDatasource;
        this.remoteDatasource = remoteDatasource;
    }

    @Override
    public void detail(final long itemId, final DetailCallback<T> callback) {
        localDatasource.detail(itemId, new Datasource.DetailCallback<T>() {
            @Override
            public void onSuccess(T data) {
                if (data != null) {
                    callback.onSuccess(data);
                } else {
                    remoteDatasource.detail(itemId, new Datasource.DetailCallback<T>() {
                        @Override
                        public void onSuccess(T data) {
                            if (data != null) {
                                localDatasource.save(data, new Datasource.SaveCallback<T>() {
                                    @Override
                                    public void onSuccess(T data) {
                                        callback.onSuccess(data);
                                    }

                                    @Override
                                    public void onError(ErrorInfo error) {
                                        callback.onError(error);
                                    }
                                });
                            } else {
                                callback.onError(new ErrorInfo(Keys.ResultCodes.emptyData, "No hay datos en ningún sitio"));
                            }
                        }

                        @Override
                        public void onError(ErrorInfo error) {
                            callback.onError(error);
                        }
                    });
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void refresh(DateTime dateTime, final ListCallback<T> callback) {
        remoteDatasource.refresh(dateTime, new Datasource.ListCallback<T>() {
            @Override
            public void onSuccess(List<T> data) {
                if (data != null && data.size() > 0) {
                    localDatasource.save(data, new Datasource.SaveListCallback<T>() {
                        @Override
                        public void onSuccess(List<T> data) {
                            callback.onSuccess(data);
                        }

                        @Override
                        public void onError(ErrorInfo error) {
                            callback.onError(error);
                        }
                    });
                } else {
                    callback.onSuccess(data);
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void list(final ListCallback<T> callback) {
        localDatasource.list(new Datasource.ListCallback<T>() {
            @Override
            public void onSuccess(List<T> data) {
                if (data != null && data.size() > 0) {
                    callback.onSuccess(data);
                } else {
                    remoteDatasource.list(new Datasource.ListCallback<T>() {
                        @Override
                        public void onSuccess(List<T> data) {
                            localDatasource.save(data, new Datasource.SaveListCallback<T>() {
                                @Override
                                public void onSuccess(List<T> data) {
                                    callback.onSuccess(data);
                                }

                                @Override
                                public void onError(ErrorInfo error) {
                                    callback.onError(error);
                                }
                            });
                        }

                        @Override
                        public void onError(ErrorInfo error) {
                            callback.onError(error);
                        }
                    });
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                callback.onError(error);
            }
        });
    }
}
