package peaksoft.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Student;
import peaksoft.services.student.StudentService;

@Controller
@RequestMapping("/student/students")
public class StudentController1 {

    private final StudentService studentService;

    @Autowired
    public StudentController1(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "/student/students";
    }

    @GetMapping("/add-student")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/student/add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/students";
    }

    @GetMapping("/update-student/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getByIdStudent(id));
        return "/student/update-student";
    }

    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(student, id);
        return "redirect:/student/students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/students";
    }
}
