package com.spring.assignment.service;

import com.spring.assignment.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService{
    public List<Course> findAllCourse();
    public String addCourse(Course course);
    public Course findId(int id);
}
