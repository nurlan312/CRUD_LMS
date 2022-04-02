package peaksoft.services.student;

import org.springframework.stereotype.Service;
import peaksoft.daos.Student.StudentDao;
import peaksoft.models.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getByIdStudent(Long id) {
        return studentDao.getByIdStudent(id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        studentDao.updateStudent(student, id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }
}