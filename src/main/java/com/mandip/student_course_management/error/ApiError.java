package com.mandip.student_course_management.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus statusCode;


    public ApiError(String error, HttpStatus statusCode) {
        this.timeStamp = LocalDateTime.now();
        this.error = error;
        this.statusCode = statusCode;
    }

    public ApiError(){

    }
}
