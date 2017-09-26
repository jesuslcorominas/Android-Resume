package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 *
 * Clase que modela las distintas imagenes de un proyecto.
 */
public class ProjectImage {

    private Long id;

    private Long projectId;
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
