package com.samvel.uexample.student;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void should_thorw_npe_when_studentDto_is_null() {
        var message = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto is null", message.getMessage());
    }

    @Test
    public void shouldMapStudenttoStudentResponseDto() {
        Student student = new Student("Samvel", "Israelyan", "samvel@gmail.com", 46);
        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        assertNotNull(dto);
        assertEquals(student.getFirstname(), dto.firstname());
        assertEquals(student.getLastname(), dto.lastname());
        assertEquals(student.getEmail(), dto.email());
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("John", "Doe", "john@mail.com", 1);
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }
}