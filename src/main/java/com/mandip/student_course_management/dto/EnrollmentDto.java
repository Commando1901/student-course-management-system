package com.mandip.student_course_management.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
//    private String grade;
}
