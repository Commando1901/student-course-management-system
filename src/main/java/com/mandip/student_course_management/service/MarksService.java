package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MarksService {

    MarksDto addMarks(MarksDto marksDto);

    String calculateGradeLogic(int marks);

    MarksDto updateMarks(MarksDto marksDto);

    Page<MarksDto> getMarksByStudentId(Long studentId, Pageable pageable);

    Page<MarksDto> getAllMarks(Pageable pageable);

    List<MarksDto> getMarksByStudentId(Long studentId);

//    MarksDto getMarkByStudentId(Long id);
}
