package com.jesuslcorominas.resume.model.vo;

/**
 * Created by Jesús López Corominas
 * 26/09/2017.
 */
public class ErrorInfo {

    private final int errorCode;
    private final String message;

    public ErrorInfo(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
