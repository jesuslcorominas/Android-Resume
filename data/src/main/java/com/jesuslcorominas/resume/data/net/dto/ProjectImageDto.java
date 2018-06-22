package com.jesuslcorominas.resume.data.net.dto;

import org.joda.time.DateTime;

/**
 * @author Jesús López Corominas
 */
public class ProjectImageDto extends AbstractBaseDto{

    private DateTime update;
    private ProjectDto project;

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
