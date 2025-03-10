package com.samvel.uexample.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.schoolName());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
