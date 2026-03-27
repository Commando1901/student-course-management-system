package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.EnrollmentDto;
import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Course;
import com.mandip.student_course_management.entity.Enrollment;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.repository.CourseRepository;
import com.mandip.student_course_management.repository.EnrollmentRepositoy;
import com.mandip.student_course_management.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepositoy enrollmentRepositoy;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    @Override
    public void enrollStudent(EnrollmentDto enrollmentDto) {
        boolean exists = enrollmentRepositoy
                .existsByStudentIdAndCourseId(enrollmentDto.getStudentId(), enrollmentDto.getCourseId());

        if(exists){
            throw new RuntimeException("Student already enrolled in this course");
        }

        Student student = studentRepository.findById(enrollmentDto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: "+ enrollmentDto.getStudentId()));

        Course course = courseRepository.findById(enrollmentDto.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: "+ enrollmentDto.getCourseId()));

//        Student student = modelMapper.map(studentDto, Student.class);
//        student.setCreatedAt(LocalDateTime.now());
//        Enrollment enrollment = modelMapper.map(enrollmentDto, Enrollment.class);
//        enrollment .setEnrollmentDate(LocalDateTime.now());
//        return modelMapper.map(enrollmentRepositoy.save(enrollment), EnrollmentDto.class);

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setGrade(enrollment.getGrade());

        enrollmentRepositoy.save(enrollment);
    }
}
