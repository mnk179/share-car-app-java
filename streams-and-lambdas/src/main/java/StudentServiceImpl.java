import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private List<Student> students = StudentRepository.getInstance().getStudents();

    @Override
    public Optional<Student> getFullStudentById(long studentId) {
        return students.stream()
                .filter(student -> student.getStudentId() == studentId)
                .findFirst();

    }

    @Override
    public List<SimpleStudent> getAllStudents() {
        return students.stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SimpleStudent> getStudentById(long studentId) {
        final Optional<Student> studentById = getFullStudentById(studentId);
        return studentById.map(this::transform);
    }

    private SimpleStudent transform(Student student) {
        return new SimpleStudent(student.getStudentId(),
                student.getName() + student.getSurname(),
                student.getGraduationDate(),
                student.getGrades());
    }

    @Override
    public List<String> getAllPhoneNumbers() {
        return null;
    }
}
