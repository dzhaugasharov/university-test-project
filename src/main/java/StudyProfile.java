public enum StudyProfile {
    MEDICINE("Медицина"),
    FINANCE("Финансы"),
    IT("Информационные технологии");

    private String value;

    StudyProfile(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
