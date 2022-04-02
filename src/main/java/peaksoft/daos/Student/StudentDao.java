package peaksoft.daos.Student;

import peaksoft.models.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getByIdStudent(Long id);

    void updateStudent(Student student, Long id);

    void deleteStudent(Long id);
}