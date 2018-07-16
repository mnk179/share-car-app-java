import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.util.stream.Collectors.toList;

public class StudentRepository {

    private static volatile StudentRepository instance = null;

    private StudentRepository() {
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }

    private List<Student> people = init();

    private List<Student> init() {
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(this.getClass().getResourceAsStream("/people.csv"))).build()) {

            return reader.readAll()
                    .stream().map(record -> new Student(Long.valueOf(record[0]),
                            record[1],
                            record[2],
                            LocalDate.parse(record[3]))
                    ).collect(toList());

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public List<Student> getPersons() {
        return new ArrayList<>(people);
    }
}
