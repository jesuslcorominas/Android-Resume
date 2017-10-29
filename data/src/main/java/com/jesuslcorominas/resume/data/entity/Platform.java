package com.jesuslcorominas.resume.data.entity;

/**
 * @author Jesús López Corominas
 */
public enum Platform {

    UNDEFINED(0), ANDROID(1), IOS(2), TIZEN(3), WINDOWS_MOBILE(4), MOBILE_DEVICES(5), TRAINING(6);

    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Platform getPlatform(Integer value) {
        if (value == null) {
            return null;
        }

        for (Platform platform : Platform.values()) {
            if (platform.value == value) {
                return platform;
            }
        }

        return Platform.UNDEFINED;
    }

}
