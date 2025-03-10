package com.samvel.uexample.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        // given
        StudentDto dto = new StudentDto("John", "Doe", "john@mail.com", 1);
        Student student = new Student("John", "Doe", "john@mail.com", 1);
        Student savedStudent = new Student("John", "Doe", "john@mail.com", 1);
        savedStudent.setId(1);

        // Mock the calls
        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(
                new StudentResponseDto("John", "Doe", "john@mail.com"));

        // when
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        // then
        assertEquals(dto.firstname(), responseDto.firstname());
        assertEquals(dto.lastname(), responseDto.lastname());
        assertEquals(dto.email(), responseDto.email());
    }
}