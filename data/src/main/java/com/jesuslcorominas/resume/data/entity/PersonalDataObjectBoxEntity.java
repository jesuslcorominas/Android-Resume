package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;

import org.joda.time.DateTime;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author Jesús López Corominas
 */
@Entity
public class PersonalDataObjectBoxEntity extends AbstractObjectBoxBaseEntity {

    private String surname;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime birthdate;

    private String email;
    private String phoneNumber;
    private String summary;
    private String image;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }
}
