package com.jesuslcorominas.resume.model.vo;

import org.joda.time.DateTime;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 * <p>
 * Clase que modela la formación complementaria del CV.
 */
public class OtherTraining {

    private Long id;

    private String name;
    private String school;
    private DateTime date;
    private int hours;
    private String image;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
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
