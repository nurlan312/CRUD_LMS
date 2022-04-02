//package peaksoft.controllers.teacher;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.models.Teacher;
//import peaksoft.services.course.CourseService;
//import peaksoft.services.teacher.TeacherService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/teacher/teachers")
//public class TeacherController {
//
//    private final TeacherService teacherService;
//    private final CourseService courseService;
//
//    public TeacherController(TeacherService teacherService, CourseService courseService) {
//        this.teacherService = teacherService;
//        this.courseService = courseService;
//    }
//
//    @GetMapping()
//    public String getTeachers(@RequestParam("courseId") Long courseId, Model model) {
//        List<Teacher> teacherList = new ArrayList<>();
//        try {
//            for (Teacher t : teacherService.getAllTeachers()) {
//                if (t.getCourse().getId().equals(courseId)) {
//                    teacherList.add(t);
//                }
//            }
//        } catch (NullPointerException e) {
//            System.out.println("It is empty");
//        }
//        model.addAttribute("teachers", teacherList);
//        return "/teacher/teachers";
//    }
//
//    @GetMapping("/add-teacher")
//    public String addTeacher(@RequestParam("courseId") Long courseId, Model model) {
//        model.addAttribute("teacher", new Teacher());
//        return "/teacher/add-teacher";
//    }
//
//    @PostMapping("/save-teacher")
//    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @RequestParam("courseId") Long id) {
//        teacher.setCourse(courseService.getByIdCourse(id));
//        teacherService.saveTeacher(teacher);
//        return "redirect:/teacher/teachers?courseId" + id;
//    }
//
//    @GetMapping("/teacher/edit-teacher/{id}")
//    public String editTeacher(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("teacher", teacherService.getByIdTeacher(id));
//        return "teacher/update-teacher";
//    }
//
//    @PatchMapping("/teacher/update-teacher/{id}")
//    public String updateTeacher(@PathVariable("id") Long id, @ModelAttribute("teacher") Teacher teacher) {
//        teacherService.updateTeacher(teacher, id);
//        return "redirect:/teacher/teachers";
//    }
//
//    @DeleteMapping("/teacher/deleteTeacher/{id}")
//    public String deleteTeacher(@PathVariable("id") Long id) {
//        teacherService.deleteTeacher(id);
//        return "redirect:/teacher/teachers";
//    }
//}
