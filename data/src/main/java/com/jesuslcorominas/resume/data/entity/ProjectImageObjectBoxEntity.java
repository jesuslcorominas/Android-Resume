package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.relation.ToOne;

/**
 * @author Jesús López Corominas
 */

@Entity
public class ProjectImageObjectBoxEntity extends AbstractObjectBoxBaseEntity {

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    private ToOne<ProjectObjectBoxEntity> project;

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public ToOne<ProjectObjectBoxEntity> getProject() {
        return project;
    }

    public void setProject(ToOne<ProjectObjectBoxEntity> project) {
        this.project = project;
    }
}
