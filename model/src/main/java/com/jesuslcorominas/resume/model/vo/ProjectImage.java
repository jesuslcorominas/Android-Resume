package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 22/09/2017.
 *
 * Clase que modela las distintas imagenes de un proyecto.
 */
public class ProjectImage {

    private Long id;
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
