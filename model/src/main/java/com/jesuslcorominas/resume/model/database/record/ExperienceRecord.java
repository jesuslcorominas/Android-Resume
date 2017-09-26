package com.jesuslcorominas.resume.model.database.record;

import com.jesuslcorominas.resume.model.vo.Position;
import com.orm.SugarRecord;

import org.joda.time.DateTime;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 */
public class ExperienceRecord extends AbstractSugarRecord {

    private String companyName;
    private String image;
    private String start;
    private String end;
    private Position position;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
