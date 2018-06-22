package com.jesuslcorominas.resume.commons.model;

import org.joda.time.DateTime;

/**
 * @author Jesús López Corominas
 */
public class OtherData extends AbstractBaseVo {

    private String description;

    private DateTime update;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }
}
