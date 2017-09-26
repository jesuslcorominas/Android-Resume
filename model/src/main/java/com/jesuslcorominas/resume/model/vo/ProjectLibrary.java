package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
public class ProjectLibrary {

    private Long id;

    private Long projectId;
    private Long libraryId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }
}
