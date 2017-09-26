package com.jesuslcorominas.resume.model.database.conversor;

import com.orm.SugarRecord;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public interface RecordConversor<V, R extends SugarRecord> {

    V toValueObject(R record);
    R toRecord(V vo);
}
