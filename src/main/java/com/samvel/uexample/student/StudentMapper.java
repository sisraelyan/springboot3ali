package com.samvel.uexample.student;

import com.samvel.uexample.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
    }

    public Student toStudent(StudentDto dto) {
        if(dto == null) {
            throw new NullPointerException("The student Dto is null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }
}
