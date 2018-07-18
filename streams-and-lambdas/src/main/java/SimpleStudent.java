
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SimpleStudent {

    private long studentId;
    private String nameAndSurname;
    private LocalDate graduationDate;
    private Map<Student.Subject, Integer> grades = new HashMap<>();

    public SimpleStudent() {
    }

    public SimpleStudent(long studentId, String nameAndSurname, LocalDate graduationDate, Map<Student.Subject, Integer> grades) {
        this.studentId = studentId;
        this.nameAndSurname = nameAndSurname;
        this.graduationDate = graduationDate;
        this.grades = grades;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Map<Student.Subject, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<Student.Subject, Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "SimpleStudent{" +
                "studentId=" + studentId +
                ", nameAndSurname='" + nameAndSurname + '\'' +
                ", graduationDate=" + graduationDate +
                ", grades=" + grades +
                '}';
    }
}
