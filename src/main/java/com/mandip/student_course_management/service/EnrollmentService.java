package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.EnrollmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnrollmentService {

    void enrollStudent(EnrollmentDto enrollmentDto);

    void updateEnrollment(Long id, EnrollmentDto enrollmentDto);

    EnrollmentDto getEnrollmentById(Long id);

    Page<EnrollmentDto> getAllEnrollments(Pageable pageable);

    java.util.List<EnrollmentDto> getEnrollmentsByStudentId(Long studentId);
}
