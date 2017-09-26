package com.jesuslcorominas.resume.model.database.record;

import com.orm.SugarRecord;
import com.orm.dsl.MultiUnique;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
@MultiUnique("projectId, libraryId")
public class ProjectLibraryRecord extends AbstractSugarRecord {

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
