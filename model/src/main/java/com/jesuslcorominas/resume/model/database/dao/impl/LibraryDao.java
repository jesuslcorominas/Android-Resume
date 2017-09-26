package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.LibraryRecord;
import com.jesuslcorominas.resume.model.vo.Library;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
@EBean
public class LibraryDao extends AbstractDao<Library, LibraryRecord> {

    @Override
    public void init() {
        setClasses(Library.class, LibraryRecord.class);
    }
}
