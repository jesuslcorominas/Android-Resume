package com.jesuslcorominas.resume.data.net.dto;

import com.jesuslcorominas.resume.commons.model.Platform;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ProjectDto extends AbstractBaseDto {

    private String description;
    private Platform platform;
    private String icon;
    private String path;
    private DateTime update;

    private ExperienceDto experience;

    private List<LibraryDto> libraries;
    private List<ProjectImageDto> images;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public ExperienceDto getExperience() {
        return experience;
    }

    public void setExperience(ExperienceDto experience) {
        this.experience = experience;
    }

    public List<LibraryDto> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryDto> libraries) {
        this.libraries = libraries;
    }

    public List<ProjectImageDto> getImages() {
        return images;
    }

    public void setImages(List<ProjectImageDto> images) {
        this.images = images;
    }
}
