import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StatisticUtils {

    public static List<Statistics> generateStatistics(List<Student> students, List<University> universities) {
        List<Statistics> report = new ArrayList<>();

        for (StudyProfile sp : StudyProfile.values()) {
            Statistics statistics = new Statistics(sp, null, 0, 1, null);
            List<University> filteredUniversities = universities.stream().filter(u -> u.getMainProfile().equals(sp)).collect(Collectors.toList());
            int totalUniversities = filteredUniversities.size();
            String[] universityTitles = new String[filteredUniversities.size()];
            int i = 0;
            for (University u : filteredUniversities) {
                universityTitles[i] = u.getShortName();
                i++;
            }

            long totalStudents = students.stream().filter(s -> {
                Optional<University> any = universities.stream()
                        .filter(u -> s.getUniversityId().equals(u.getId()) && u.getMainProfile().equals(sp))
                        .findAny();
                return any.isPresent();
            }).count();

            OptionalDouble average = students.stream()
                    .filter(student -> {
                        Optional<University> any = universities.stream()
                                .filter(u -> student.getUniversityId().equals(u.getId()) && u.getMainProfile().equals(sp))
                                .findAny();
                        return any.isPresent();
                    })
                    .flatMapToDouble(student -> DoubleStream.of(student.getAvgExamScore())).average();

            statistics.setTotalUniversities(totalUniversities);
            statistics.setTotalStudents((int) totalStudents);
            if (average.isPresent())
                statistics.setAverageExamMark(average.getAsDouble());
            statistics.setUniversityTitles(universityTitles);
            report.add(statistics);
        }


        return report;
    }

}
