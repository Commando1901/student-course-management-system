package com.mandip.student_course_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email is required")
    private String email;

}
