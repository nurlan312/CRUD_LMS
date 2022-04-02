//package peaksoft.controllers.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.models.Student;
//import peaksoft.services.group.GroupService;
//import peaksoft.services.student.StudentService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller @RequestMapping("/student/students")
//public class StudentController {
//
//    private final StudentService studentService;
//    private final GroupService groupService;
//
//    @Autowired
//    public StudentController(StudentService studentService, GroupService groupService) {
//        this.studentService = studentService;
//        this.groupService = groupService;
//    }
//
//    @GetMapping
//    public String getStudents(@RequestParam("groupId") Long groupId, Model model) {
//        List<Student> studentList = new ArrayList<>();
//        try {
//            for (Student s : studentService.getAllStudents()) {
//                if (s.getGroup2().getId().equals(groupId)) {
//                    studentList.add(s);
//                }
//            }
//        } catch (NullPointerException e) {
//            System.out.println("It is empty");
//        }
//        model.addAttribute("students", studentList);
//        return "/student/students";
//    }
//
//    @GetMapping("/add-student")
//    public String addStudent(@RequestParam("groupId") Long groupId, Model model) {
//        model.addAttribute("student", new Student());
//        return "/student/add-student";
//    }
//
//    @PostMapping("/save-student")
//    public String saveStudent(@ModelAttribute("student") Student student, @RequestParam("groupId") Long id) {
//        student.setGroup2(groupService.getByIdGroup(id));
//        studentService.saveStudent(student);
//        return "redirect:/student/students?groupId" + id;
//    }
//
//    @GetMapping("/edit-student/{id}")
//    public String editStudent(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("student", studentService.getByIdStudent(id));
//        return "/student/update-student";
//    }
//
//    @PatchMapping("/update-student/{id}")
//    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
//        studentService.updateStudent(student, id);
//        return "redirect:/student/students";
//    }
//
//    @DeleteMapping("/delete-student/{id}")
//    public String deleteStudent(@PathVariable("id") Long id) {
//        studentService.deleteStudent(id);
//        return "redirect:/student/students";
//    }
//}
