package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.MarksDto;
import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PutMapping
    public MarksDto updateMarks(
            @RequestBody MarksDto marksDto){

        return marksService.updateMarks(marksDto);

    }

//    public Page<StudentDto> getStudents(Pageable pageable){
//        return studentService.getStudents(pageable);
//    }
    @GetMapping("/student/{studentId}")
    public Page<MarksDto> getStudentMark(@PathVariable Long studentId, Pageable pageable){
        return marksService.getMarksByStudentId(studentId, pageable);
    }

    @GetMapping("/all")
    public Page<MarksDto> getMarks(Pageable pageable){
        return marksService.getAllMarks(pageable);
    }



}
