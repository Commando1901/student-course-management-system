package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarksService {

    MarksDto addMarks(MarksDto marksDto);

    String calculateGradeLogic(int marks);

    MarksDto updateMarks(MarksDto marksDto);

    Page<MarksDto> getMarksByStudentId(Long studentId, Pageable pageable);

    Page<MarksDto> getAllMarks(Pageable pageable);

//    MarksDto getMarkByStudentId(Long id);
}
