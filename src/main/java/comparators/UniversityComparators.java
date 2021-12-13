package comparators;

import model.University;
import org.apache.commons.lang3.StringUtils;


public class UniversityComparators {

    public static class ById implements UniversityComparator {
        public int compare(University university1, University university2) {
            return StringUtils.compare(university1.getId(), university2.getId());
        }
    }

    public static class ByFullName implements UniversityComparator {
        public int compare(University university1, University university2) {
            return StringUtils.compare(university1.getFullName(), university2.getFullName());
        }
    }

    public static class ByShortName implements UniversityComparator {
        public int compare(University university1, University university2) {
            return StringUtils.compare(university1.getShortName(), university2.getShortName());
        }
    }

    public static class ByYearOfFoundation implements UniversityComparator {
        public int compare(University university1, University university2) {
            return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
        }
    }

    public static class ByMainProfile implements UniversityComparator {
        public int compare(University university1, University university2) {
            return university1.getMainProfile().compareTo(university2.getMainProfile());
        }
    }
}
