package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 * <p>
 * Enumerado con los distintos niveles posibles de un conocimiento.
 */
public enum KnowledgeLevel {

    UNDEFINED(0), BASIC(1), MEDIUM(2), ADVANCED(3);

    private final int value;

    KnowledgeLevel(int value) {
        this.value = value;
    }

    public static KnowledgeLevel getKnowledgeLevel(final int value) {
        if (value == BASIC.value) {
            return BASIC;
        } else if (value == MEDIUM.value) {
            return MEDIUM;
        } else if (value == ADVANCED.value) {
            return ADVANCED;
        }

        return UNDEFINED;
    }

    public int getValue() {
        return this.value;
    }

}
