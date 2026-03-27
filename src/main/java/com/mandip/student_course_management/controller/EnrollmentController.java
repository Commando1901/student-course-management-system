package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.EnrollmentDto;
import com.mandip.student_course_management.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping()
    public String enroll(@RequestBody EnrollmentDto enrollmentDto){
        enrollmentService.enrollStudent(enrollmentDto);
        return "Student enrolled successfully!";
    }
}
