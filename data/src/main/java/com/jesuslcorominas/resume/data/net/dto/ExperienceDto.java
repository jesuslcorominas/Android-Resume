package com.jesuslcorominas.resume.data.net.dto;

import com.jesuslcorominas.resume.commons.model.Position;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ExperienceDto extends AbstractBaseDto {

    private String image;
    private DateTime start;
    private DateTime end;
    private Position position;
    private String description;
    private DateTime update;

    private List<ProjectDto> projects;

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

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }

}
