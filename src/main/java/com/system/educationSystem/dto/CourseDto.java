package com.system.educationSystem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CourseDto {
    private final String name;
    private final String description;
    private final Long teacherId;
}
