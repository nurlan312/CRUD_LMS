package peaksoft.daos.course;

import peaksoft.models.Course;

import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    List<Course> getAllCourses();

    Course getByIdCourse(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}
