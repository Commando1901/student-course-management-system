package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.CourseDto;
import com.mandip.student_course_management.service.CourseService;
import com.mandip.student_course_management.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

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

    @GetMapping("/{id}/courses")
    public Page<CourseDto> getCoursesByStudent(@PathVariable Long id, Pageable pageable){

         return courseService.getCourseByStudentId(id, pageable);
    }

}
