package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class Language {

    private Long id;

    private String name;
    private KnowledgeLevel level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KnowledgeLevel getLevel() {
        return level;
    }

    public void setLevel(KnowledgeLevel level) {
        this.level = level;
    }
}
