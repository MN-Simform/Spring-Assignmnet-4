package com.spring.assignment.service;

import com.spring.assignment.entity.Course;
import com.spring.assignment.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Course> findAllCourse() {
        if (courseRepository.count() == 0) {
            logger.warn("No Records Exist : {}", courseRepository.count());
        } else {
            logger.info("{} Record Fetched Successfully", courseRepository.count());
        }
        return courseRepository.findAll();
    }

    @Override
    public String addCourse(Course course) {

        if (course.getId() != 0 && course.getName() != null && course.getPrice() != 0) {
            courseRepository.save(course);
            logger.info("Data Has Been Added Successfully");
            return "Data Added Successfully";
        } else {
            logger.warn("Data Has Not Been Added");
            return "Something Went Wrong";
        }
    }

    @Override
    public Course findId(int id) {
        Course course = courseRepository.findById(id);
        try {
            if (course != null) {
                logger.info("Id :'" + id + "' Fetched");
                return course;
            } else {
                logger.error("Id :'" + id + "' doesn't exist");
                throw new NullPointerException();
            }
        } catch (Exception e) {
            logger.error("Exception Caught {}" , e.getMessage());
        }
        return course;
    }
}
