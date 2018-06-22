package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.relation.ToMany;

/**
 * @author Jesús López Corominas
 */
@Entity
public class LibraryObjectBoxEntity extends AbstractObjectBoxBaseEntity{

    private String path;
    private String description;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    private ToMany<ProjectObjectBoxEntity> projects;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public ToMany<ProjectObjectBoxEntity> getProjects() {
        return projects;
    }

    public void setProjects(ToMany<ProjectObjectBoxEntity> projects) {
        this.projects = projects;
    }
}
