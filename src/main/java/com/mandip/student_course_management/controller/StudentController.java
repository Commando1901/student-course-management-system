package com.mandip.student_course_management.controller;

import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
//    public List<StudentDto> getAllStudents(){
//        return studentService.getAllStudents();
//    }
    public Page<StudentDto> getStudents(Pageable pageable){
        return studentService.getStudents(pageable);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentDto studentDto){

        return studentService.createStudent(studentDto);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(
                @PathVariable Long id,
                @RequestBody StudentDto studentDto){

        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

//    @GetMapping("/name/{name}")
//    public List<StudentDto> getByName(@PathVariable String name){
//        return studentService.findByName(name);
//    }

    @GetMapping("/exists/email/{email}")
    public boolean existByEmail(@PathVariable String email){
        return studentService.existByEmail(email);
    }

    @GetMapping("search")
    public Page<StudentDto> searchStudents(
            @RequestParam String name,
            Pageable pageable){

        return studentService.searchStudents(name,pageable);
    }
}
