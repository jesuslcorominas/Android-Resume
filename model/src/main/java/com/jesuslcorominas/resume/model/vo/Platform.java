package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas (dev.jesus.lopez.corominas@gmail.com)
 * 22/09/2017.
 *
 * Enumerado de las distintas plataformas posibles de un proyecto
 */
public enum Platform {

    UNDEFINED(0), ANDROID(1), IOS(2), TIZEN(3), PHONEGAP(4), WINDOWS_MOBILE(5), WEB(6),;

    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Platform getPlatform(int value) {
        if (value == ANDROID.value) {
            return ANDROID;
        } else if (value == IOS.value) {
            return IOS;
        } else if (value == TIZEN.value) {
            return TIZEN;
        } else if (value == PHONEGAP.value) {
            return PHONEGAP;
        } else if (value == WINDOWS_MOBILE.value) {
            return WINDOWS_MOBILE;
        } else if (value == WEB.value) {
            return WEB;
        }

        return UNDEFINED;
    }


}
