package enums;

public enum StudyProfile {
    FINANCE("Финансы"),
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");

    private String value;

    StudyProfile(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
