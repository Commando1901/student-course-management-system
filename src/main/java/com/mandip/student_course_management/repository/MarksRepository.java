package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.dto.MarksDto;
import com.mandip.student_course_management.entity.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarksRepository extends JpaRepository<Marks, Long>{

    boolean existsByStudent_IdAndCourse_Id(Long studentId, Long courseId);

    Optional<Marks> findByStudent_IdAndCourse_Id(Long studentId, Long courseId);

    Page<Marks> findByStudent_Id(Long studentId, Pageable pageable);
}
