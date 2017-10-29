package com.jesuslcorominas.resume.app.util;

import android.content.Context;

import com.jesuslcorominas.resume.app.R;

/**
 * @author Jesús López Corominas
 */
public final class Utils {

    private Utils() {

    }

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
