package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long studentId);


//    List<Student> findByName(String name);
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
