package com.jesuslcorominas.resume.data.entity;

import io.objectbox.annotation.BaseEntity;
import io.objectbox.annotation.Id;

/**
 * @author Jesús López Corominas
 */
@BaseEntity
public abstract class AbstractObjectBoxBaseEntity {

    @Id(assignable = true)
    private Long id;

    private String name;

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
}
