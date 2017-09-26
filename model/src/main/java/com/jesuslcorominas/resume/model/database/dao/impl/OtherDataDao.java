package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.OtherDataRecord;
import com.jesuslcorominas.resume.model.vo.OtherData;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class OtherDataDao extends AbstractDao<OtherData, OtherDataRecord> {

    @Override
    public void init() {
        setClasses(OtherData.class, OtherDataRecord.class);
    }
}
