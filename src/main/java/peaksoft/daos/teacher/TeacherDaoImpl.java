package peaksoft.daos.teacher;

import org.springframework.stereotype.Repository;
import peaksoft.models.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("select t from Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher getByIdTeacher(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void updateTeacher(Teacher teacher, Long id) {
        Teacher teacher1 = getByIdTeacher(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(teacher.getCourse());
        entityManager.merge(teacher1);
    }

    @Override
    public void deleteTeacher(Long id) {
        entityManager.remove(getByIdTeacher(id));
    }
}