package com.jesuslcorominas.resume.app.util;

import android.support.annotation.StringRes;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.commons.model.Position;

/**
 * @author Jesús López Corominas
 */
public final class PositionHelper {

    private PositionHelper() {

    }

    @StringRes
    public static int getValue(Position position) {
        switch (position) {
            case LEARNER:
                return R.string.position_learner;
            case TRAINER:
                return R.string.position_trainer;
            case DEVELOPER:
                return R.string.position_developer;
            case UNDEFINED:
                return R.string.value_undefined;
        }

        return R.string.value_undefined;
    }
}
