package com.jesuslcorominas.resume.commons.util;

/**
 * @author Jesús López Corominas
 */
public final class TextUtils {

    private TextUtils(){

    }

    public static String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }
}
