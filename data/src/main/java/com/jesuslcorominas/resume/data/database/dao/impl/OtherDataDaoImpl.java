package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.entity.OtherData;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDaoImpl extends AbstractObjectBoxDao<OtherData> implements OtherDataDao {

    @Inject
    public OtherDataDaoImpl(Box<OtherData> box) {
        super(box);
    }
}
