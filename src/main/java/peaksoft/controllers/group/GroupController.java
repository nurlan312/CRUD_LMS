package peaksoft.controllers.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Group2;
import peaksoft.services.group.GroupService;

@Controller
@RequestMapping("/group/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String getGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "/group/groups";
    }

    @GetMapping("/add-group")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group2());
        return "/group/add-group";
    }

    @PostMapping("/save-group")
    public String saveGroup(@ModelAttribute("group") Group2 group) {
        groupService.saveGroup(group);
        return "redirect:/group/groups";
    }

    @GetMapping("/update-group/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model) {
        model.addAttribute("group", groupService.getByIdGroup(id));
        return "/group/update-group";
    }

    @PostMapping("/edit-group/{id}")
    public String editGroup(@PathVariable("id") Long id, @ModelAttribute("group") Group2 group) {
        groupService.updateGroup(group, id);
        return "redirect:/group/groups";
    }

    @GetMapping("/delete-group/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
        return "redirect:/group/groups";
    }
}