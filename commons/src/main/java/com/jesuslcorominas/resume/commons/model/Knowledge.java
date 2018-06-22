package com.jesuslcorominas.resume.commons.model;

import org.joda.time.DateTime;

import java.util.Comparator;

/**
 * @author Jesús López Corominas
 */
public class Knowledge extends AbstractBaseVo {

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

    public static class KnowledgesComparator implements Comparator<Knowledge> {

        @Override
        public int compare(Knowledge o1, Knowledge o2) {
            if (o1 == null) {
                // Si el primero es nulo va delante
                return 1;
            }

            if (o2 == null) {
                // Si el segundo es nulo va delante
                return -1;
            }

            if (o1.getType() != null) {
                // Si el tipo del primero no es nulo
                if (o2.getType() != null) {
                    // Si el tipo del segundo tampoco lo, comparamos ambos tipos
                    int compareTypes = o1.getType().compareTo(o2.getType());
                    if (compareTypes != 0) {
                        // Si no tienen el mismo tipo
                        return compareTypes;
                    }
                } else {
                    // Si estamos aqui el primero tiene tipo y el segundo no, con lo que va delante
                    return -1;
                }
            } else if (o2.getType() != null) {
                // Si estamos aqui, el primero no tiene inicio y el segundo si, con lo que el primero va delante
                return 1;
            }

            // Si estamos aqui es que ninguno tiene tipo o ambos tienen el mismo
            if (o1.getLevel() != null) {
                // Si el nivel del primero no es nulo
                if (o2.getLevel() != null) {
                    // Si el nivel del segundo tampoco lo es, comparamos ambos niveles
                    int compareLevels = o2.getLevel().compareTo(o1.getLevel());
                    if (compareLevels != 0) {
                        // Si no tienen el mismo nivel
                        return compareLevels;
                    }
                } else {
                    // Si estamos aqui el primero tiene nivel y el segundo no, con lo que va delante
                    return -1;
                }
            } else if (o2.getLevel() != null) {
                // Si estamos aqui, el primero no tiene nivel y el segundo si, con lo que el primero va delante
                return 1;
            }

            return Long.valueOf(o2.getId()).compareTo(o1.getId());
        }
    }
}
