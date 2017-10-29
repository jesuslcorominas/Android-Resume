package com.jesuslcorominas.resume.data.entity;

/**
 * @author Jesús López Corominas
 */
public enum Position {

    UNDEFINED(0), DEVELOPER(1), TRAINER(2), LEARNER(3);

    private final int value;

    Position(int value) {
        this.value = value;
    }

    public static Position getPosition(Integer value) {
        if (value == null) {
            return null;
        }

        for (Position position : Position.values()) {
            if (position.value == value) {
                return position;
            }
        }

        return UNDEFINED;
    }

    public int getValue() {
        return value;
    }

}
