package com.jesuslcorominas.resume.model.database.dao.impl;

import com.jesuslcorominas.resume.model.database.record.ProjectImageRecord;
import com.jesuslcorominas.resume.model.vo.ProjectImage;

import org.androidannotations.annotations.EBean;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
@EBean
public class ProjectImageDao extends AbstractDao<ProjectImage, ProjectImageRecord> {

    @Override
    public void init() {
        setClasses(ProjectImage.class, ProjectImageRecord.class);
    }
}
