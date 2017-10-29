package com.jesuslcorominas.resume.data.entity;

/**
 * @author Jesús López Corominas
 */
public enum KnowledgeType {

    UNDEFINED(0), MOBILE_DEVELOPMENT(1), PROGRAMMING_LANGUAGE(2);

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
