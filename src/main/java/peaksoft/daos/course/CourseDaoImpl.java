package peaksoft.daos.course;

import org.springframework.stereotype.Repository;
import peaksoft.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course saveCourse(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course getByIdCourse(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Course course1 = getByIdCourse(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setGroups(course.getGroups());
        course1.setTeacher(course.getTeacher());
        entityManager.merge(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        entityManager.remove(getByIdCourse(id));
    }
}
