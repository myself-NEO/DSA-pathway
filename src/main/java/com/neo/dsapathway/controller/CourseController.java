package com.neo.dsapathway.controller;

import com.neo.dsapathway.dto.CreateCourseRequest;
import com.neo.dsapathway.model.Course;
import com.neo.dsapathway.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourseToUser(@RequestBody CreateCourseRequest createCourseRequest) {
        Course course = courseService.createCourse(createCourseRequest);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("courseByUser")
    public ResponseEntity<List<Course>> getAllCoursesByUser(@RequestParam Integer userId) {
        List<Course> courseList = courseService.getAllCoursesByUser(userId);
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

}
