package com.spring.assignment.controller;

import com.spring.assignment.entity.Course;
import com.spring.assignment.service.CourseService;
import com.spring.assignment.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> retrieveData(){
        return courseService.findAllCourse();
    }

    @RequestMapping(value = "/add_course", method = RequestMethod.POST)
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "/findCourseId", method = RequestMethod.GET)
    public Course findCourseById(@RequestParam(name = "id") int id){
        return courseService.findId(id);
    }
}
