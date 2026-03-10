package com.mandip.student_course_management.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDto {

    private Long id;

    private String title;

    private String description;
}
