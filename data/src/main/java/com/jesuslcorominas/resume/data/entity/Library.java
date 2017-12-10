package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Library {

    @Id(assignable = true)
    private long id;

    private String name;
    private String path;
    private String description;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    private ToMany<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public ToMany<Project> getProjects() {
        return projects;
    }

    public void setProjects(ToMany<Project> projects) {
        this.projects = projects;
    }
}
