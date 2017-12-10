package com.jesuslcorominas.resume.data.entity;

import com.jesuslcorominas.resume.data.database.converter.DateConverter;

import org.joda.time.DateTime;

import java.util.Comparator;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Training {

    @Id(assignable = true)
    private long id;

    private String name;
    private String school;
    private Float mark;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime start;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime end;

    private int hours;

    private Boolean official;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Boolean getOfficial() {
        return official;
    }

    public void setOfficial(Boolean official) {
        this.official = official;
    }

    public DateTime getUpdate() {
        return update;
    }

    public void setUpdate(DateTime update) {
        this.update = update;
    }

    public static class TrainingComparator implements Comparator<Training> {
        @Override
        public int compare(Training o1, Training o2) {
            if (o1 == null) {
                // Si el primero es nulo va delante
                return 1;
            }

            if (o2 == null) {
                // Si el segundo es nulo va delante
                return -1;
            }

            if (o1.getOfficial() && !o2.getOfficial()) {
                // Si el primero es oficial y el segundo no, el primero va delante
                return -1;
            }

            if (o2.getOfficial() && !o1.getOfficial()) {
                // Si el segundo es oficial y el primero no, el segundo va delante
                return 1;
            }

            if (o1.getEnd() != null) {
                // Si el final del primero no es nulo
                if (o2.getEnd() != null) {
                    // Si el final del segundo tampoco lo, comparamos ambos finales
                    int compareEnds = o2.getEnd().compareTo(o1.getEnd());
                    if (compareEnds != 0) {
                        // Si no tienen el mismo final
                        return o2.getEnd().compareTo(o1.getEnd());
                    }
                } else {
                    // Si estamos aqui el primero tiene fin y el segundo no, con lo que va delante
                    return -1;
                }
            } else if (o2.getEnd() != null) {
                // Si estamos aqui, el primero no tiene fin y el segundo si, con lo que el primero va delante
                return 1;
            }

            // Si estamos aqui es que ambos finales son nulos por lo que comparamos los inicios
            if (o1.getStart() != null) {
                // Si el inicio del primero no es nulo
                if (o2.getStart() != null) {
                    // Si el inicio del segundo tampoco lo, comparamos ambos inicios
                    int compareStarts = o2.getStart().compareTo(o1.getStart());
                    if (compareStarts != 0) {
                        // Si no tienen el mismo inicio
                        return o2.getStart().compareTo(o1.getStart());
                    }
                } else {
                    // Si estamos aqui el primero tiene inicio y el segundo no, con lo que va delante
                    return -1;
                }
            } else if (o2.getStart() != null) {
                // Si estamos aqui, el primero no tiene inicio y el segundo si, con lo que el primero va delante
                return 1;
            }

            return Long.valueOf(o2.getId()).compareTo(o1.getId());
        }
    }
}
