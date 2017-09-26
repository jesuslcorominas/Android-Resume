package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.ProjectLibraryRecord;
import com.jesuslcorominas.resume.model.vo.ProjectLibrary;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class ProjectLibraryDao extends AbstractDao<ProjectLibrary, ProjectLibraryRecord> {

    @Override
    public void init() {
        setClasses(ProjectLibrary.class, ProjectLibraryRecord.class);
    }
}
