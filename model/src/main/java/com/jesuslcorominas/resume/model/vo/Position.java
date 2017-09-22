package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 22/09/2017.
 *
 * Clase que modela las distintos puestos posibles de una experiencia
 */
public enum Position {

    UNDEFINED(0), DEVELOPER(1), TRAINER(2), LEARNER(3);

    private final int value;

    Position(int value) {
        this.value = value;
    }

    public static Position getPosition(int value) {
        if (value == DEVELOPER.value) {
            return DEVELOPER;
        } else if (value == TRAINER.value) {
            return TRAINER;
        } else if (value == LEARNER.value) {
            return LEARNER;
        }

        return UNDEFINED;
    }

}
