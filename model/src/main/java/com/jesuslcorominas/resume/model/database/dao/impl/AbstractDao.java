package com.jesuslcorominas.resume.model.database.dao.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import com.jesuslcorominas.resume.model.database.conversor.RecordConversor;
import com.jesuslcorominas.resume.model.database.conversor.impl.GenericRecordConversor;
import com.jesuslcorominas.resume.model.database.dao.Dao;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public abstract class AbstractDao<V, R extends SugarRecord> implements Dao<V, R> {

    private static final String TAG = AbstractDao.class.getName();

    @RootContext
    protected Context context;

    private RecordConversor<V, R> conversor;

    private Class<R> recordClazz;
    private Class<V> voClazz;

    @AfterInject
    public abstract void init();

    protected final void setClasses(Class<V> voClazz, Class<R> recordClazz) {
        this.voClazz = voClazz;
        this.recordClazz = recordClazz;
    }

    protected final void setConversor(RecordConversor<V, R> conversor) {
        this.conversor = conversor;
    }

    public SQLiteOpenHelper getOpenHelper(final String dataBaseName, final Integer dataBaseVersion) {
        return new SQLiteOpenHelper(context, dataBaseName, null, dataBaseVersion) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            }
        };
    }

    public void closeOpenHelper(SQLiteOpenHelper helper) {
        helper.close();
    }

    @Override
    public List<V> get() {
        return get("", "");
    }

    @Override
    public List<V> get(String columnName, String filterValue) {
        Select<R> select = Select.from(recordClazz);
        if (!TextUtils.isEmpty(columnName) && !TextUtils.isEmpty(filterValue)) {
            select.where(Condition.prop(columnName).eq(filterValue));
        }

        List<R> records = select.list();
        List<V> valueObjects = new ArrayList<>();

        for (R record : records) {
            valueObjects.add(convert(record));
        }

        return valueObjects;
    }

    @Override
    public List<V> get(String query, String... params) {
        List<R> records = R.findWithQuery(recordClazz, query, params);
        List<V> valueObjects = new ArrayList<>();
        for (R record : records) {
            valueObjects.add(convert(record));
        }

        return valueObjects;
    }

    @Override
    public V save(final V item) {
        List<V> items = new ArrayList<>();
        items.add(item);
        return this.save(items).get(0);
    }

    @Override
    public List<V> save(final List<V> items) {
        List<V> persistedItems = new ArrayList<>();
        for (V item : items) {
            R record = convert(item);
            record.setId(record.save());
            persistedItems.add(convert(record));
        }

        return persistedItems;
    }

    @Override
    public void delete(final List<V> items) {
        int size = items.size();

        for (int i = 0; i < size; i++) {
            convert(items.get(i)).delete();
        }
    }

    @Override
    public void delete(String columnName, String filterValue) {
        SugarRecord.deleteAll(recordClazz, columnName + " == ?" + filterValue);
    }

    private V convert(R record) {
        return (conversor == null ? (new GenericRecordConversor<>(voClazz, recordClazz)) : conversor).toValueObject(record);
    }

    private R convert(V valueObject) {
        return (conversor == null ? (new GenericRecordConversor<>(voClazz, recordClazz)) : conversor).toRecord(valueObject);
    }
}
