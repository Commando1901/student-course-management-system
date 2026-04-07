package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.MarksDto;
import com.mandip.student_course_management.service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarksController {

    private final MarksService marksService;

    @PostMapping
    public MarksDto createMarks(@RequestBody MarksDto marksDto){
        return marksService.addMarks(marksDto);
    }

}
