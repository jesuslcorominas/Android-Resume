package com.jesuslcorominas.resume.data.database.dao.impl;

import com.jesuslcorominas.resume.data.entity.OtherData;

import javax.inject.Inject;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDao extends AbstractObjectBoxDao<OtherData> {

    @Inject
    public OtherDataDao(Box<OtherData> box) {
        super(box);
    }
}
