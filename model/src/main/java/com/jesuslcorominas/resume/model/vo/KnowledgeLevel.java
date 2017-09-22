package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 22/09/2017.
 * <p>
 * Enumerado con los distintos niveles posibles de un conocimiento.
 */
public enum KnowledgeLevel {

    UNDEFINED(0), BASIC(1), MEDIUM(2), ADVANCED(3);

    private int value;

    KnowledgeLevel (int value) {
        this.value = value;
    }

    public static KnowledgeLevel getKnowledgeLevel(int value) {
        if (value == BASIC.value) {
            return BASIC;
        } else if (value == MEDIUM.value) {
            return MEDIUM;
        } else if (value == ADVANCED.value) {
            return ADVANCED;
        }

        return UNDEFINED;
    }

}
