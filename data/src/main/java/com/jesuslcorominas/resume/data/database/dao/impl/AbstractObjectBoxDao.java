package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.Dao;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.Query;

/**
 * // TODO agregar metodos para buscar y borrar por el nombre de la columna
 *
 * @author Jesús López Corominas
 */
public abstract class AbstractObjectBoxDao<V> implements Dao<V> {

    protected Box<V> box;

    AbstractObjectBoxDao(Box<V> box) {
        this.box = box;
    }

    @Override
    public List<V> getAll() {
        return find(null);
    }

    @Override
    public List<V> find(Property columnProperty, String filterValue) {
        return find(box.query().equal(columnProperty, filterValue).build());
    }

    @Override
    public V findById(long itemId) {
        return box.get(itemId);
    }

    @Override
    public List<V> find(Query<V> query) {
        if (query == null) {
            return box.getAll();
        }

        return query.find();
    }

    @Override
    public V save(V item) {
        box.put(item);

        return item;
    }

    @Override
    public List<V> save(List<V> items) {
        box.put(items);

        return items;
    }

    @Override
    public void delete(List<V> items) {
        box.remove(items);
    }

    @Override
    public void delete(Property columnProperty, String filterValue) {
        delete(box.query().equal(columnProperty, filterValue).build());
    }

    @Override
    public void delete(Query<V> query) {
        box.remove(find(query));
    }

}
