package com.jesuslcorominas.resume.data.entity;

import com.google.gson.annotations.SerializedName;
import com.jesuslcorominas.resume.data.database.converter.DateConverter;
import com.jesuslcorominas.resume.data.database.converter.PositionConverter;

import org.joda.time.DateTime;

import java.util.Comparator;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * @author Jesús López Corominas
 */
@Entity
public class Experience {

    @Id(assignable = true)
    private long id;

    @SerializedName("company_name")
    private String companyName;
    private String image;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime start;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime end;

    @Convert(converter = PositionConverter.class, dbType = Integer.class)
    private Position position;

    private String description;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    private DateTime update;

    // TODO mirar si puede hacerse privado con un detail/set
    @Backlink
    public ToMany<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

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

    public static class ExperiencesComparator implements Comparator<Experience> {

        @Override
        public int compare(Experience o1, Experience o2) {
            if (o1 == null) {
                // Si el primero es nulo va delante
                return 1;
            }

            if (o2 == null) {
                // Si el segundo es nulo va delante
                return -1;
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
