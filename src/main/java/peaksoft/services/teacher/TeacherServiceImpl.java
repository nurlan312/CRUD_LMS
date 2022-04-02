package peaksoft.services.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.daos.teacher.TeacherDao;
import peaksoft.models.Teacher;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public Teacher getByIdTeacher(Long id) {
        return teacherDao.getByIdTeacher(id);
    }

    @Override
    public void updateTeacher(Teacher teacher, Long id) {
        teacherDao.updateTeacher(teacher, id);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherDao.deleteTeacher(id);
    }
}