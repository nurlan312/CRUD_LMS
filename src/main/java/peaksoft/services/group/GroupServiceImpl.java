package peaksoft.services.group;

import org.springframework.stereotype.Service;
import peaksoft.daos.group.GroupDao;
import peaksoft.models.Group2;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group2 saveGroup(Group2 group) {
        return groupDao.saveGroup(group);
    }

    @Override
    public List<Group2> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public Group2 getByIdGroup(Long id) {
        return groupDao.getBuIdGroup(id);
    }

    @Override
    public void updateGroup(Group2 group, Long id) {
        groupDao.updateGroup(group, id);
    }

    @Override
    public void deleteGroup(Long id) {
        groupDao.deleteGroup(id);
    }
}
