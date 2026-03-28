package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
