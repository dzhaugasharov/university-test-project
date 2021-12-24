import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        try {
            log.info("Program started");
            List<University> universities = XlsReader.readXlsUniversities("src\\main\\resources\\universityInfo.xlsx");
            List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");

            List<Statistics> statistics = StatisticUtils.generateStatistics(students, universities);
            XlsWriter.writeToXlsx(statistics, "src/main/resources/report.xlsx");
        }
        catch (IOException e) {
            log.log(Level.SEVERE, (Supplier<String>) e);
        }
    }
}
