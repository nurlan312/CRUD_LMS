package peaksoft.controllers.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Course;
import peaksoft.services.course.CourseService;

@Controller
@RequestMapping("/course/courses")
public class CourseController1 {

    private final CourseService courseService;

    public CourseController1(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "/course/courses";
    }

    @GetMapping("/add-course")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "/course/add-course";
    }

    @PostMapping("/save-course")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/course/courses";
    }

    @GetMapping("/update-course/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", courseService.getByIdCourse(id));
        return "/course/update-course";
    }

    @PostMapping("/edit-course/{id}")
    public String editCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course) {
        courseService.updateCourse(course, id);
        return "redirect:/course/courses";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/courses";
    }
}
