package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksDto;
import com.mandip.student_course_management.entity.Course;
import com.mandip.student_course_management.entity.Marks;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.repository.CourseRepository;
import com.mandip.student_course_management.repository.MarksRepository;
import com.mandip.student_course_management.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MarksServiceImpl implements MarksService{

    private final ModelMapper modelMapper;
    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public MarksDto addMarks(MarksDto marksDto) {

        if(marksDto.getStudentId() == null || marksDto.getCourseId() == null){
            throw new RuntimeException("Input can't be null!");
        }

        boolean exists = marksRepository.existsByStudent_IdAndCourse_Id(marksDto.getStudentId(), marksDto.getCourseId());

        if(exists){
            throw new RuntimeException("Marks of student of course already exists!");
        }

        int marks = marksDto.getMarks();
        String grade = calculateGradeLogic(marks);

        Student student = studentRepository.findById(marksDto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not exists with id : " + marksDto.getStudentId()));

        Course course = courseRepository.findById(marksDto.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id : " + marksDto.getCourseId()));

        Marks marks1 = new Marks();
        marks1.setMarks(marks);
        marks1.setGrade(grade);
        marks1.setMarksDate(LocalDateTime.now());
        marks1.setStudent(student);
        marks1.setCourse(course);

        return modelMapper.map(marksRepository.save(marks1), MarksDto.class);
    }

    public String calculateGradeLogic(int marks){

        if(marks >= 90) return "AA";
        else if(marks >= 80) return "AB";
        else if(marks >= 70) return "BB";
        else if(marks >= 60) return "BC";
        else if(marks >= 50) return "CC";
        else if(marks >= 40) return "CD";
        else return "DD";
    }
}
