package com.jesuslcorominas.resume.model.database.record;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class KnowledgeRecord extends AbstractSugarRecord {

    private String name;
    private String image;
    private int type;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
