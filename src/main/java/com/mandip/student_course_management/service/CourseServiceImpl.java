package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.CourseDto;
import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Course;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {

        Course course = modelMapper.map(courseDto, Course.class);
        return modelMapper.map(courseRepository.save(course),CourseDto.class);
    }

    @Override
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable)
                .map(course -> modelMapper.map(course,CourseDto.class));
    }

    @Override
    public CourseDto getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: "+id));

        return modelMapper.map(course,CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {

//        Student student =  studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//
//
//        student.setName(studentDto.getName());
//        student.setEmail(studentDto.getEmail());
//
//        return modelMapper.map(studentRepository.save(student), StudentDto.class);

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: "+id));

        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());

        return modelMapper.map(courseRepository.save(course),CourseDto.class);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: "+id));

        courseRepository.delete(course);
    }
}
