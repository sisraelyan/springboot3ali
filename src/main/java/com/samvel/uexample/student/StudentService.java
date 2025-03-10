package com.samvel.uexample.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var savedStudent = repository.save(studentMapper.toStudent(studentDto));
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        List<StudentResponseDto> students = repository.findAll().stream().
                map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
        return students;
    }

    public StudentResponseDto findById(Integer id) {
        StudentResponseDto student = repository.findById(id).stream().
                map(studentMapper::toStudentResponseDto).findFirst().orElse(null);
        return student;
    }

    public List<StudentResponseDto> findByFirstNameContaining(String firstname) {
        List<StudentResponseDto> students = repository.findAllByFirstnameContaining(firstname).stream().
                map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
        return students;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
