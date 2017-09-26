package com.jesuslcorominas.resume.model.database.record;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class ProjectImageRecord extends AbstractSugarRecord {

    private Long projectId;

    private String path;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
