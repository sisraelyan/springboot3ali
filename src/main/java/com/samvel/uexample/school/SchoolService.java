package com.samvel.uexample.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto dtoSchool) {
        var school = this.schoolMapper.toSchool(dtoSchool);
        schoolRepository.save(school);
        return dtoSchool;
    }

    public List<SchoolDto> findAll() {
        return schoolRepository.findAll().stream().map(this.schoolMapper::toSchoolDto).collect(Collectors.toList());
    }
}
