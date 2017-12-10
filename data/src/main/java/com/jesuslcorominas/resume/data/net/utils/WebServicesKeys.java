package com.jesuslcorominas.resume.data.net.utils;

/**
 * @author Jesús López Corominas
 */
public final class WebServicesKeys {

    private WebServicesKeys() {

    }

    public static final class Paths {
        private static final String detail = "{" + Fields.id + "}/";

        public static final String training = "training/";

        public static final String experience = "experience/";

        public static final String knowledge = "knowledge/";

        public static final String otherData = "other_data/";

        public static final String personalData = "personal_data/";

        public static final String project = "project/";
    }

    public static final class Fields {
        public static final String id = "id";

        public static final String lastUpdated = "last_updated";
    }
}
