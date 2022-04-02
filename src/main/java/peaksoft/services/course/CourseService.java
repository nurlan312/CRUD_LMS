package peaksoft.services.course;

import peaksoft.models.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);

    List<Course> getAllCourses();

    Course getByIdCourse(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}
