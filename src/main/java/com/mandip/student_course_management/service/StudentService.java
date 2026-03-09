package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    Page<StudentDto> getStudents(Pageable pageable);

    StudentDto updateStudent(Long id, StudentDto studentDto);

    void deleteStudent(Long id);

//    List<StudentDto> findByName(String name);

    Page<StudentDto> searchStudents(String name, Pageable pageable);

    boolean existByEmail(String email);
}
