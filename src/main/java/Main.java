import comparators.StudentComparator;
import comparators.UniversityComparator;
import enums.StudentSort;
import enums.UniversitySort;
import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<University> universities = XlsReader.readXlsUniversities("src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator = Utils.getUniversityComparator(UniversitySort.FULL_NAME);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        System.out.println("");

        List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Utils.getStudentComparator(StudentSort.AVG_EXAM_SCORE);
        students.stream().sorted(studentComparator).forEach(System.out::println);

        List<Statistics> statistics = StatisticUtils.generateStatistics(students, universities);
        XlsWriter.writeToXlsx(statistics, "src/main/resources/report.xlsx");
    }
}
