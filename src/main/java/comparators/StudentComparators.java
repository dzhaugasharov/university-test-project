package comparators;

import model.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentComparators {
    public static class ByFullName implements StudentComparator {
        @Override
        public int compare(Student student, Student t1) {
            return StringUtils.compare(student.getFullName(), t1.getFullName());
        }
    }

    public static class ByCurrentCourseNumber implements StudentComparator {
        @Override
        public int compare(Student student, Student t1) {
            return StringUtils.compare(student.getFullName(), t1.getFullName());
        }
    }

    public static class ByUniversityId implements StudentComparator {
        @Override
        public int compare(Student student, Student t1) {
            return StringUtils.compare(student.getUniversityId(), t1.getUniversityId());
        }
    }

    public static class ByAvgExamScore implements StudentComparator {
        @Override
        public int compare(Student student, Student t1) {
            return Float.compare(t1.getAvgExamScore(), student.getAvgExamScore());
        }
    }


}
