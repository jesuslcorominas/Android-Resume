package com.jesuslcorominas.resume.model.database.record;

import com.orm.SugarRecord;

import org.joda.time.DateTime;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class OtherTrainingRecord extends AbstractSugarRecord {

    private String name;
    private String school;
    private String date;
    private int hours;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
