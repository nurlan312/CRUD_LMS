package peaksoft.daos.teacher;

import peaksoft.models.Teacher;

import java.util.List;

public interface TeacherDao {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getByIdTeacher(Long id);

    void updateTeacher(Teacher teacher, Long id);

    void deleteTeacher(Long id);
}