package com.mandip.student_course_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarksheetDto {
    private long studentId;
    private String studentName;
//    private String courseName;

    private List<SubjectMarksDto> subjects;

    private int totalMarks;
    private double percentage;

    private String grade;
    private String result; // PASS / FAIL
    private String issueDate;
}
