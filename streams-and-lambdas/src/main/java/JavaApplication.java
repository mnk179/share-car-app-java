import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaApplication {


    public static void main(String[] args) {
        final List<Student> students = StudentRepository.getInstance().getStudents();

        students.forEach(System.out::println);

        System.out.println("--------------------------------");

        final List<SimpleStudent> mike = students.stream()
                .filter(student -> student.getName() != null &&
                        student.getName().equals("Mike"))
                .map(student ->
                        new SimpleStudent(student.getStudentId(),
                                student.getName() + student.getSurname(),
                                student.getGraduationDate(),
                                student.getGrades()))
                .collect(Collectors.toList());
        final Student student = new Student(1L, "Vardenis", "Pavardenis", LocalDate.now());

        final Map<Student.Subject, Integer> grades = List.of(Student.Subject.MATHEMATICAL_ANALYSIS, Student.Subject.INTERNET_SECURITY)
                .stream()
                .collect(Collectors.toMap(o -> o, o -> 4));
        student.setGrades(grades);

    }

}
