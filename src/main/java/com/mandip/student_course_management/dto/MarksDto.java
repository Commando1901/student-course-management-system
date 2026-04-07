package com.mandip.student_course_management.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarksDto {

    private Long id;

    private Long studentId;

    private Long courseId;

    private int marks;

    private String grade;

}
