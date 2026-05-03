package com.mandip.student_course_management.service;

import com.mandip.student_course_management.dto.MarksheetDto;
import com.mandip.student_course_management.dto.SubjectMarksDto;
import com.mandip.student_course_management.entity.Marks;
import com.mandip.student_course_management.entity.Student;
import com.mandip.student_course_management.repository.MarksRepository;
import com.mandip.student_course_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarksheetServiceImple implements MarksheetService{

    private final StudentRepository studentRepository;
    private final MarksRepository marksRepository;

    @Override
    public MarksheetDto generateMarksheet(long studentId) {

        // fetch student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        // fetch marks
        List<Marks> marksList = marksRepository.findByStudent_Id(studentId);

        // convert to subjectmarksdto
        List<SubjectMarksDto> subjectMarksDtoList = new ArrayList<>();

        int total = 0;
        for(Marks mark : marksList){

            SubjectMarksDto subjectMarksDto = new SubjectMarksDto();

            subjectMarksDto.setSubjectName(mark.getCourse().getTitle());
            subjectMarksDto.setMarks(mark.getMarks());

            subjectMarksDtoList.add(subjectMarksDto);

            total += mark.getMarks();
        }

        // calculate percentage
        double percentage = 0;
        if(!marksList.isEmpty()){
            percentage = (double)total/ marksList.size();
        }

        // build marksheetDto
        MarksheetDto marksheetDto = new MarksheetDto();
        marksheetDto.setStudentId(student.getId());
        marksheetDto.setStudentName(student.getName());

        marksheetDto.setSubjects(subjectMarksDtoList);
        marksheetDto.setTotalMarks(total);
        marksheetDto.setPercentage(Math.round(percentage * 100.0) / 100.0);

        String grade = getGrade(percentage);

        marksheetDto.setGrade(grade);
        marksheetDto.setResult(getResult(grade));
        marksheetDto.setIssueDate(LocalDate.now().toString());

        return marksheetDto;
    }

    public String getGrade(double percentage){

        if(percentage >= 85) return "A";
        else if(percentage >= 70) return "B";
        else if(percentage >= 60) return "C";
        else if(percentage >= 40) return "D";
        else return "F";

    }

    public String getResult(String grade){
        if(grade.equals("F")){
            return "FAIL";
        }
        else return "PASS";
    }

}
