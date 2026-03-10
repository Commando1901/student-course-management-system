package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.CourseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);

    Page<CourseDto> getAllCourses(Pageable pageable);

    CourseDto getCourseById(Long id);

    CourseDto updateCourse(Long id, CourseDto courseDto);

    void deleteCourse(Long id);
}
