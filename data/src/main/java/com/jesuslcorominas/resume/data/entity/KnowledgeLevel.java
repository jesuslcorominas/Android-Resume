package com.jesuslcorominas.resume.data.entity;

/**
 * @author Jesús López Corominas
 */
public enum KnowledgeLevel {

    UNDEFINED(0), BASIC(1), MEDIUM(2), ADVANCED(3);

    private final int value;

    KnowledgeLevel(int value) {
        this.value = value;
    }

    public static KnowledgeLevel getKnowledgeLevel(Integer value) {
        if (value == null) {
            return null;
        }

        for (KnowledgeLevel knowledgeLevel : KnowledgeLevel.values()) {
            if (knowledgeLevel.value == value) {
                return knowledgeLevel;
            }
        }

        return UNDEFINED;
    }

    public int getValue() {
        return this.value;
    }
}
