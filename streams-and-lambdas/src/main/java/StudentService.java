
import java.util.List;
import java.util.function.Function;

public interface StudentService {

    Student getFullStudentById(long studentId);

    List<SimpleStudent> getAllStudents();

    SimpleStudent getStudentById(long studentId);

    <T> SimpleStudent findStudentBy(T value, Function<Student, T> valueAccessor);

}
