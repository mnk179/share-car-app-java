public class StudentUtils {

    void printBestProgammer(Student s1, Student s2, Student s3) {
        StudentComparator studentComparator = this::bestProgrammer;

        studentComparator.compare(studentComparator.compare(s1, s2), s3);
    }

    private Student bestProgrammer(Student student1, Student student2) {
        System.out.println("Comparing students");

        final Student bestStudent = student1.getGrades().get(Student.Subject.OBJECT_ORIENTED_PROGRAMMING) >
                student2.getGrades().get(Student.Subject.OBJECT_ORIENTED_PROGRAMMING) ? student1 : student2;
        System.out.println("Best student is " + bestStudent.getName());
        return bestStudent;
    }
}

