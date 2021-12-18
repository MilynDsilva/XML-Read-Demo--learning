package com.toreadxmlfile.learning.controller;

import com.toreadxmlfile.learning.LearningService.LearningServiceImpl;
import com.toreadxmlfile.learning.SomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LearningController {

    @Autowired
    private LearningServiceImpl learningService;
//    //private  priority priority;
    @GetMapping("/home")
    public String home() {
        return ("home");
    }

    @GetMapping("/some")
    public List<SomeDTO> getDetails() {
        return this.learningService.getDetails();
    }
}



    //get courses
//    @GetMapping("/courses")
//    public List<Course> getCourses()
//    {
//        return this.courseSerivice.getCourses();
//    }
//    @GetMapping("/courses/{courseId}")
//
//    public  Course getCourse(@PathVariable String courseId) //to recieve
//    {
//        return this.courseSerivice.getCourse(Long.parseLong(courseId));
//    }

//    @PostMapping("/courses")
//
////    @PostMapping(path = "/courses",consumes = "application/json")
//    public Course addCourse(@RequestBody Course course)
//    {
//        return this.courseSerivice.addCourse(course);
//    }
//

