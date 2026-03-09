package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
