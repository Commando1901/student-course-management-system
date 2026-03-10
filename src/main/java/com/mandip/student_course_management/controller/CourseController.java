package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.CourseDto;
import com.mandip.student_course_management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }

    @GetMapping
    public Page<CourseDto> getAllCourses(Pageable pageable){
        return courseService.getAllCourses(pageable);
    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto){
        return courseService.updateCourse(id,courseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

}
