package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksDto;

public interface MarksService {

    MarksDto addMarks(MarksDto marksDto);

    String calculateGradeLogic(int marks);
}
