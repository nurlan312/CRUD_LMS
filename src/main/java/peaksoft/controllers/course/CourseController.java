//package peaksoft.controllers.course;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import peaksoft.models.Course;
//import peaksoft.services.company.CompanyService;
//import peaksoft.services.course.CourseService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller @RequestMapping("/course/courses")
//public class CourseController {
//
//    private final CompanyService companyService;
//    private final CourseService courseService;
//
//
//    @Autowired
//    public CourseController(CompanyService companyService, CourseService courseService) {
//        this.companyService = companyService;
//        this.courseService = courseService;
//    }
//
//    @GetMapping
//    public String getCourses(@RequestParam("companyId") Long companyId, Model model) {
//        List<Course> courseList = new ArrayList<>();
//        try {
//            for (Course c : courseService.getAllCourses()) {
//                if (c.getCompany().getId().equals(companyId)) {
//                    courseList.add(c);
//                }
//            }
//        } catch (NullPointerException e) {
//            System.out.println("It is empty");
//        }
//        model.addAttribute("courses", courseList);
//        return "/course/courses";
//    }
//
//    @GetMapping("/add-course")
//    public String addCourse(@RequestParam("companyId") Long companyId, Model model) {
//        model.addAttribute("course", new Course());
//        return "/course/add-course";
//    }
//
//    @PostMapping("/save-course")
//    public String saveCourse(@ModelAttribute("course") Course course, @RequestParam("companyId") Long id) {
//        course.setCompany(companyService.getByIdCompany(id));
//        courseService.saveCourse(course);
//        return "redirect:/course/courses";
//    }
//
//    @GetMapping("/update-course/{id}")
//    public String updateCourse(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("course", courseService.getByIdCourse(id));
//        return "/course/update-course";
//    }
//
//    @PostMapping("/edit-course/{id}")
//    public String editCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course) {
//        courseService.updateCourse(course, id);
//        return "redirect:/course/courses";
//    }
//
//    @DeleteMapping("/delete-course/{id}")
//    public String deleteCourse(@PathVariable("id") Long id) {
//        courseService.deleteCourse(id);
//        return "redirect:/course/courses";
//    }
//}