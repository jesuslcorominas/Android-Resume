package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.commons.model.Platform;
import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.PlatformConverter;

import org.joda.time.DateTime;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

/**
 * @author Jesús López Corominas
 */
@Entity
public class ProjectObjectBoxEntity extends AbstractObjectBoxBaseEntity{

    private String description;

    @Convert(converter = PlatformConverter.class, dbType = Integer.class)
    private Platform platform;

    private String icon;
    private String path;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    private ToOne<ExperienceObjectBoxEntity> experience;

    private ToMany<LibraryObjectBoxEntity> librariesRelation;

    @Backlink
    private ToMany<ProjectImageObjectBoxEntity> imagesRelation;

    @Transient
    private List<LibraryObjectBoxEntity> libraries;

    @Transient
    private List<ProjectImageObjectBoxEntity> images;

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

    public ToOne<ExperienceObjectBoxEntity> getExperience() {
        return experience;
    }

    public void setExperience(ToOne<ExperienceObjectBoxEntity> experience) {
        this.experience = experience;
    }

    public ToMany<LibraryObjectBoxEntity> getLibrariesRelation() {
        return librariesRelation;
    }

    public void setLibrariesRelation(ToMany<LibraryObjectBoxEntity> librariesRelation) {
        this.librariesRelation = librariesRelation;
    }

    public List<LibraryObjectBoxEntity> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryObjectBoxEntity> libraries) {
        this.libraries = libraries;
    }

    public ToMany<ProjectImageObjectBoxEntity> getImagesRelation() {
        return imagesRelation;
    }

    public void setImagesRelation(ToMany<ProjectImageObjectBoxEntity> imagesRelation) {
        this.imagesRelation = imagesRelation;
    }

    public List<ProjectImageObjectBoxEntity> getImages() {
        return images;
    }

    public void setImages(List<ProjectImageObjectBoxEntity> images) {
        this.images = images;
    }
}
