package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.ProjectRecord;
import com.jesuslcorominas.resume.model.vo.Project;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 26/09/2017.
 */
@EBean
public class ProjectDao extends AbstractDao<Project, ProjectRecord> {

    @Override
    public void init() {
        setClasses(Project.class, ProjectRecord.class);
    }
}
