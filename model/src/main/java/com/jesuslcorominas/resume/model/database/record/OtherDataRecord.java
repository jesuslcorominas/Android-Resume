package com.jesuslcorominas.resume.model.database.record;

import com.orm.SugarRecord;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class OtherDataRecord extends AbstractSugarRecord {

    private String name;
    private String description;

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
