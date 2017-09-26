package com.jesuslcorominas.resume.model.database.record;

import com.orm.dsl.MultiUnique;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class AcademicTrainingRecord extends AbstractSugarRecord {

    private String name;
    private String school;
    private String start;
    private String end;
    private String mark;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
