package com.neo.dsapathway.service;

import com.neo.dsapathway.dto.CreateCourseRequest;
import com.neo.dsapathway.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CreateCourseRequest createCourseRequest);
    List<Course> getAllCoursesByUser(Integer userId);
}
