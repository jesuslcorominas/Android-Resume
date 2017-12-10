package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.PlatformConverter;

import org.joda.time.DateTime;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Project {

    @Id(assignable = true)
    private long id;

    private String name;
    private String description;

    @Convert(converter = PlatformConverter.class, dbType = Integer.class)
    private Platform platform;

    private String icon;
    private String path;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    private ToOne<Experience> experience;

    private ToMany<Library> librariesRelation;

    @Backlink
    private ToMany<ProjectImage> imagesRelation;

    @Transient
    private List<Library> libraries;

    @Transient
    private List<ProjectImage> images;

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

    public ToOne<Experience> getExperience() {
        return experience;
    }

    public void setExperience(ToOne<Experience> experience) {
        this.experience = experience;
    }

    public ToMany<Library> getLibrariesRelation() {
        return librariesRelation;
    }

    public void setLibrariesRelation(ToMany<Library> librariesRelation) {
        this.librariesRelation = librariesRelation;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public ToMany<ProjectImage> getImagesRelation() {
        return imagesRelation;
    }

    public void setImagesRelation(ToMany<ProjectImage> imagesRelation) {
        this.imagesRelation = imagesRelation;
    }

    public List<ProjectImage> getImages() {
        return images;
    }

    public void setImages(List<ProjectImage> images) {
        this.images = images;
    }
}
