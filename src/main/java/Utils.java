import comparators.StudentComparator;
import comparators.StudentComparators;
import comparators.UniversityComparator;
import comparators.UniversityComparators;
import enums.StudentSort;
import enums.UniversitySort;


public class Utils {

    public static StudentComparator getStudentComparator(StudentSort sortBy) {
        switch (sortBy) {
            case FULL_NAME:
                return new StudentComparators.ByFullName();
            case CURRENT_COURSE_NUMBER:
                return new StudentComparators.ByCurrentCourseNumber();
            case AVG_EXAM_SCORE:
                return new StudentComparators.ByAvgExamScore();
            case UNIVERSITY_ID:
                return new StudentComparators.ByUniversityId();
        }
        return new StudentComparators.ByFullName();
    }

    public static UniversityComparator getUniversityComparator(UniversitySort sortBy) {
        switch (sortBy) {
            case ID:
                return new UniversityComparators.ById();
            case FULL_NAME:
                return new UniversityComparators.ByFullName();
            case SHORT_NAME:
                return new UniversityComparators.ByShortName();
            case MAIN_PROFILE:
                return new UniversityComparators.ByMainProfile();
            case YEAR_OF_FOUNDATION:
                return new UniversityComparators.ByYearOfFoundation();
        }
        return new UniversityComparators.ById();
    }
}
