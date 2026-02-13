package com.system.educationSystem.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Long teacherId;
    private final String teacherFullName;
}
