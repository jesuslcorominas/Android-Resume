package com.jesuslcorominas.resume.commons.model;

/**
 * @author Jesús López Corominas
 */
public enum KnowledgeType {

    UNDEFINED(0), LANGUAGE(1), MOBILE_DEVELOPMENT(2), PROGRAMMING_LANGUAGE(3), OTHERS(4);

    private final int value;

    KnowledgeType(int value) {
        this.value = value;
    }

    public static KnowledgeType getKnowledgeType(Integer value) {
        if (value == null) {
            return null;
        }

        for (KnowledgeType knowledgeType : KnowledgeType.values()) {
            if (knowledgeType.value == value) {
                return knowledgeType;
            }
        }

        return UNDEFINED;
    }

    public int getValue() {
        return this.value;
    }

}
