package peaksoft.daos.group;

import org.springframework.stereotype.Repository;
import peaksoft.models.Group2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group2 saveGroup(Group2 group) {
        entityManager.persist(group);
        return group;
    }

    @Override
    public List<Group2> getAllGroups() {
        return entityManager.createQuery("select g from Group2 g", Group2.class).getResultList();
    }

    @Override
    public Group2 getBuIdGroup(Long id) {
        return entityManager.find(Group2.class, id);
    }

    @Override
    public void updateGroup(Group2 group, Long id) {
        Group2 group1 = getBuIdGroup(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        group1.setStudents(group.getStudents());
        entityManager.merge(group1);
    }

    @Override
    public void deleteGroup(Long id) {
        entityManager.remove(getBuIdGroup(id));
    }
}
