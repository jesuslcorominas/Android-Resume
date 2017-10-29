package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.KnowledgeLevelConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Language {

    @Id(assignable = true)
    private long id;

    private String name;

    @Convert(converter = KnowledgeLevelConverter.class, dbType = Integer.class)
    private KnowledgeLevel level;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

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

    public KnowledgeLevel getLevel() {
        return level;
    }

    public void setLevel(KnowledgeLevel level) {
        this.level = level;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }
}
