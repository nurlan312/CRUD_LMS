package peaksoft.daos.group;

import peaksoft.models.Group2;

import java.util.List;

public interface GroupDao {

    Group2 saveGroup(Group2 group);

    List<Group2> getAllGroups();

    Group2 getBuIdGroup(Long id);

    void updateGroup(Group2 group, Long id);

    void deleteGroup(Long id);
}