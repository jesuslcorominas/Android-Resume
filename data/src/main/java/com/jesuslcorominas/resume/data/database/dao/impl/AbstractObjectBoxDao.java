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
public abstract class AbstractObjectBoxDao<VO, ENTITY> implements Dao<VO, ENTITY> {

    protected Box<ENTITY> box;

    AbstractObjectBoxDao(Box<ENTITY> box) {
        this.box = box;
    }

//    @Override
//    public List<VO> getAll() {
//        return find(null);
//    }
//
//    @Override
//    public List<VO> find(Property columnProperty, String filterValue) {
//        return find(box.query().equal(columnProperty, filterValue).build());
//    }
//
//    @Override
//    public VO findById(long itemId) {
//        return box.get(itemId);
//    }
//
//    @Override
//    public List<VO> find(Query<VO> query) {
//        if (query == null) {
//            return box.getAll();
//        }
//
//        return query.find();
//    }
//
//    @Override
//    public VO save(VO item) {
//        box.put(item);
//
//        return item;
//    }
//
//    @Override
//    public List<VO> save(List<VO> items) {
//        box.put(items);
//
//        return items;
//    }
//
//    @Override
//    public void delete(List<VO> items) {
//        box.remove(items);
//    }
//
//    @Override
//    public void delete(Property columnProperty, String filterValue) {
//        delete(box.query().equal(columnProperty, filterValue).build());
//    }
//
//    @Override
//    public void delete(Query<VO> query) {
//        box.remove(find(query));
//    }


    @Override
    public List<VO> getAll() {
        return null;
    }

    @Override
    public List<VO> find(Property columnProperty, String filterValue) {
        return null;
    }

    @Override
    public List<VO> find(Query<VO> query) {
        return null;
    }

    @Override
    public VO findById(long itemId) {
        return null;
    }

    @Override
    public VO save(VO item) {
        return null;
    }

    @Override
    public List<VO> save(List<VO> items) {
        return null;
    }

    @Override
    public void delete(List<VO> items) {

    }

    @Override
    public void delete(Property columnProperty, String filterValue) {

    }

    @Override
    public void delete(Query<VO> query) {

    }
}
