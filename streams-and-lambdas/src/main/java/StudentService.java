
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface StudentService {

    Optional<Student> getFullStudentById(long studentId);

    List<SimpleStudent> getAllStudents();

    Optional<SimpleStudent> getStudentById(long studentId);

    List<String> getAllPhoneNumbers();

}
