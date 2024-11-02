package com.neo.dsapathway.service.impl;

import com.neo.dsapathway.dto.CreateCourseRequest;
import com.neo.dsapathway.model.Course;
import com.neo.dsapathway.repository.CourseRepository;
import com.neo.dsapathway.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course createCourse(CreateCourseRequest createCourseRequest) {
        Course course = createCourseRequest.toCourse();
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCoursesByUser(Integer userId) {
        List<Course> courseList = courseRepository.getCourseByUser(userId);
        return courseList;
    }
}
