package com.jesuslcorominas.resume.data.net.utils;

/**
 * @author Jesús López Corominas
 */
public final class WebServicesKeys {

    private WebServicesKeys() {

    }

    public static final class Paths {
        private static final String detail = "{" + Fields.id + "}/";

        public static final String academicTraining = "academic_training/";
        public static final String academicTrainingDetail = academicTraining + detail;

        public static final String experience = "experience/";
        public static final String experienceDetail = experience + detail;

        public static final String knowledge = "knowledge/";
        public static final String knowledgeDetail = knowledge + detail;

        public static final String language = "language/";
        public static final String languageDetail = language + detail;

        public static final String otherData = "other_data/";
        public static final String otherDataDetail = otherData + detail;

        public static final String otherTraining = "other_training/";
        public static final String otherTrainingDetail = otherTraining + detail;

        public static final String personalData = "personalData/";
        public static final String personalDataDetail = personalData + detail;

        public static final String project = "project/";
        public static final String projectDetail = project + detail;
    }

    public static final class Fields {
        public static final String id = "id";

        public static final String lastUpdated = "last_updated";
    }
}
