package com.jesuslcorominas.resume.commons.model;

import org.joda.time.DateTime;

/**
 * @author Jesús López Corominas
 */

public class ProjectImage extends AbstractBaseVo {

    private DateTime update;

    private Project project;

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
