package model;

import enums.StudyProfile;

public class Statistics {

    private StudyProfile studyProfile;
    private Double averageExamMark;
    private int totalStudents;
    private int totalUniversities;
    private String[] universityTitles;

    public Statistics(StudyProfile studyProfile, Double averageExamMark, int totalStudents, int totalUniversities, String[] universityTitles) {
        this.studyProfile = studyProfile;
        this.averageExamMark = averageExamMark;
        this.totalStudents = totalStudents;
        this.totalUniversities = totalUniversities;
        this.universityTitles = universityTitles;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public Double getAverageExamMark() {
        return averageExamMark;
    }

    public void setAverageExamMark(Double averageExamMark) {
        this.averageExamMark = averageExamMark;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalUniversities() {
        return totalUniversities;
    }

    public void setTotalUniversities(int totalUniversities) {
        this.totalUniversities = totalUniversities;
    }

    public String[] getUniversityTitles() {
        return universityTitles;
    }

    public void setUniversityTitles(String[] universityTitles) {
        this.universityTitles = universityTitles;
    }
}
