import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Student {

    private long studentId;
    private String name;
    private String surname;
    private LocalDate graduationDate;
    private Map<Subject, Integer> grades;

    public Student(long studentId, String name, String surname, LocalDate graduationDate) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.graduationDate = graduationDate;
        this.grades = Stream.of(Subject.values())
                .collect(toMap(subject -> subject, subject -> ThreadLocalRandom.current().nextInt(1, 10 + 1)));
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Map<Subject, Integer> getGrades() {
        return new HashMap<>(grades);
    }

    public void setGrades(Map<Subject, Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", graduationDate=" + graduationDate +
                ", grades=" + grades +
                '}';
    }

    public enum Subject {

        OBJECT_ORIENTED_PROGRAMMING("objectOrientedProgramming"),
        MATHEMATICAL_ANALYSIS("mathematicalAnalysis"),
        INTERNET_SECURITY("internetSecurity"),
        RDBMS_MANAGEMENT("rdbmsManagement");

        private String value;

        public String getValue() {
            return value;
        }

        Subject(String value) {
            this.value = value;
        }
    }

}
