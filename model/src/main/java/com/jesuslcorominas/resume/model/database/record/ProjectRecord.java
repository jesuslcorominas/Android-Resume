package com.jesuslcorominas.resume.model.database.record;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class ProjectRecord extends AbstractSugarRecord {

    private String name;
    private String description;
    private int platform;
    private String icon;
    private String path;

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

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
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
}
