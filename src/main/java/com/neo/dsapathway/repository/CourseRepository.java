package com.neo.dsapathway.repository;

import com.neo.dsapathway.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c from Course c where c.userId = ?1")
    List<Course> getCourseByUser(Integer userId);

}
