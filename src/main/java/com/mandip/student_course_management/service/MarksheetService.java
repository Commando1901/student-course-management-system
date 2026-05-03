package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksheetDto;


public interface MarksheetService {

    MarksheetDto generateMarksheet(long studentId);
}
