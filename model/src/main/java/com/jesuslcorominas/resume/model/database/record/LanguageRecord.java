package com.jesuslcorominas.resume.model.database.record;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class LanguageRecord extends AbstractSugarRecord {

    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
}
