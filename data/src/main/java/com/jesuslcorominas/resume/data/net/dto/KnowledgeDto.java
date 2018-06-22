package com.jesuslcorominas.resume.data.net.dto;

import com.jesuslcorominas.resume.commons.model.KnowledgeLevel;
import com.jesuslcorominas.resume.commons.model.KnowledgeType;

import org.joda.time.DateTime;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeDto extends AbstractBaseDto{

    private String image;
    private KnowledgeType type;
    private KnowledgeLevel level;
    private DateTime update;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public KnowledgeType getType() {
        return type;
    }

    public void setType(KnowledgeType type) {
        this.type = type;
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
