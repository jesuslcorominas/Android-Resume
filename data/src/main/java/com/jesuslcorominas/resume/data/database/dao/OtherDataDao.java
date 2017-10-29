package com.jesuslcorominas.resume.data.database.dao;

import com.jesuslcorominas.resume.data.entity.OtherData;

import io.objectbox.Box;

/**
 * @author Jesús López Corominas
 */
public class OtherDataDao extends AbstractObjectBoxDao<OtherData> {

    public OtherDataDao(Box<OtherData> box) {
        super(box);
    }
}
