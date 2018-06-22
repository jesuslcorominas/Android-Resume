package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.data.database.dao.OtherDataDao;
import com.jesuslcorominas.resume.data.entity.OtherDataObjectBoxEntity;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDaoImpl extends AbstractObjectBoxDao<OtherData, OtherDataObjectBoxEntity> implements OtherDataDao {

    @Inject
    public OtherDataDaoImpl(Box<OtherDataObjectBoxEntity> box) {
        super(box);
    }
}
