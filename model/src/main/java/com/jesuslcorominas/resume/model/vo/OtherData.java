package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 * <p>
 * Clase que modela otros datos del CV.
 */
public class OtherData {

    private Long id;

    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
