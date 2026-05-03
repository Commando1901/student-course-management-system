package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.EnrollmentDto;
import com.mandip.student_course_management.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody EnrollmentDto enrollmentDto){
        enrollmentService.updateEnrollment(id, enrollmentDto);
        return "Enrollment updated successfully!";
    }

    @GetMapping("/{id}")
    public EnrollmentDto getEnrollment(@PathVariable Long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @GetMapping
    public Page<EnrollmentDto> getEnrollments(Pageable pageable) {
        return enrollmentService.getAllEnrollments(pageable);
    }
}
