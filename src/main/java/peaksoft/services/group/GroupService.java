package peaksoft.services.group;

import peaksoft.models.Group2;

import java.util.List;

public interface GroupService {

    Group2 saveGroup(Group2 group);

    List<Group2> getAllGroups();

    Group2 getByIdGroup(Long id);

    void updateGroup(Group2 group, Long id);

    void deleteGroup(Long id);
}