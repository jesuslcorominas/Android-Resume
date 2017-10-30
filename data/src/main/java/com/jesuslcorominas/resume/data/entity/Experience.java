package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.PositionConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Experience {

    @Id(assignable = true)
    private long id;

    private String companyName;
    private String image;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime start;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime end;

    @Convert(converter = PositionConverter.class, dbType = Integer.class)
    private Position position;

    private String description;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    // TODO mirar si puede hacerse privado con un detail/set
    @Backlink
    public ToMany<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
}
