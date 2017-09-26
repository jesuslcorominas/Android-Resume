package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesus Lopez Corominas
 * 22/09/2017.
 * <p>
 * Enumerado con los distintos tipos de conocimientos posibles
 */
public enum KnowledgeType {

    UNDEFINDED(0), MOBILE_DEVELOPMENT(1), PROGRAMMING_LANGUAGE(2);

    private final int value;

    KnowledgeType(int value) {
        this.value = value;
    }

    public static KnowledgeType getKnowledgeType(int value) {
        if (value == MOBILE_DEVELOPMENT.value) {
            return MOBILE_DEVELOPMENT;
        } else if (value == PROGRAMMING_LANGUAGE.value) {
            return PROGRAMMING_LANGUAGE;
        }

        return UNDEFINDED;
    }

}
