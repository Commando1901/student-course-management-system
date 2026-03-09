package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.StudentDto;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

//    //Entity To Dto
//    private StudentDto mapToDto(Student student){
//        return new StudentDto(
//                student.getId(),
//                student.getName(),
//                student.getEmail()
//        );
//    }
//
//    //Dto To Entity
//    private Student mapToEntity(Student dto){
//        Student student = new Student();
//        student.setId(dto.getId());
//        student.setName(dto.getName());
//        student.setEmail(dto.getEmail());
//        return student;
//    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
       Student student = modelMapper.map(studentDto, Student.class);
       student.setCreatedAt(LocalDateTime.now());
       return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: "+ id));

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Page<StudentDto> getStudents(Pageable pageable){
        return studentRepository.findAll(pageable)
                .map(student -> modelMapper.map(student, StudentDto.class));
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {

        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));


        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

//    @Override
//    public List<StudentDto> findByName(String name) {
//        List<Student> students = studentRepository.findByName(name);
//        return students.stream()
//                .map(student -> modelMapper.map(student, StudentDto.class))
//                .toList();
//    }

    @Override
    public Page<StudentDto> searchStudents(String name, Pageable pageable){

        return studentRepository
                .findByNameContainingIgnoreCase(name, pageable)
                .map(student -> modelMapper.map(student, StudentDto.class));
    }

    @Override
    public boolean existByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }
}
