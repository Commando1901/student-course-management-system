package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.service.MarksheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mandip.student_course_management.dto.MarksheetDto;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class MarksheetController {

    private final MarksheetService marksheetService;

    @GetMapping("/marksheet/{id}")
    public MarksheetDto getMarksheet(@PathVariable long id) {
        return marksheetService.generateMarksheet(id);
    }

}
