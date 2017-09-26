package com.jesuslcorominas.resume.commons.util;

/**
 * Created by Jesús López Corominas
 * 25/09/2017.
 */
public final class TextUtils {

    private TextUtils(){

    }

    public static String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }
}
