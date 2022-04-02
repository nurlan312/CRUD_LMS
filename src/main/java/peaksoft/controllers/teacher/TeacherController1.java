package peaksoft.controllers.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Teacher;
import peaksoft.services.teacher.TeacherService;

@Controller
@RequestMapping("/teacher/teachers")
public class TeacherController1 {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController1(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "/teacher/teachers";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/teacher/add-teacher";
    }

    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher/teachers";
    }

    @GetMapping("/update-teacher/{id}")
    public String updateTeacher(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.getByIdTeacher(id));
        return "/teacher/update-teacher";
    }

    @PostMapping("/edit-teacher/{id}")
    public String editTeacher(@PathVariable("id") Long id, @ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(teacher, id);
        return "redirect:/teacher/teachers";
    }

    @GetMapping("/delete-teacher/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/teachers";
    }
}
