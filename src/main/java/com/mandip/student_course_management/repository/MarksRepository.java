package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepository extends JpaRepository<Marks, Long>{

    boolean existsByStudent_IdAndCourse_Id(Long studentId, Long courseId);
}
