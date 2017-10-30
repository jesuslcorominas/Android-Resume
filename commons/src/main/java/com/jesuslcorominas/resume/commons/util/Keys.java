package com.jesuslcorominas.resume.commons.util;

/**
 * @author Jesús López Corominas
 */
public final class Keys {

    private Keys (){

    }

    public static final class ResultCodes {
        public static final int ok = 0;

        public static final int notImplementedError = 1001;
        public static final int emptyData = 1002;
        public static final int idNotValid = 1003;

        public static final int databaseGenericError = 2001;

        public static final int serverError = 5001;
    }

    public static final class Miscellany {
        public static final String internalDateFormatter = "yyyy-MM-dd";
        public static final String printDateFormatter = "dd/MM/yyyy";
    }
}
