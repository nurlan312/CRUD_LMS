package peaksoft.services.teacher;

import peaksoft.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getByIdTeacher(Long id);

    void updateTeacher(Teacher teacher, Long id);

    void deleteTeacher(Long id);
}
