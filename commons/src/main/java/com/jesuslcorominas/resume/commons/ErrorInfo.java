package com.jesuslcorominas.resume.commons;

/**
 * @author Jesús López Corominas
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
