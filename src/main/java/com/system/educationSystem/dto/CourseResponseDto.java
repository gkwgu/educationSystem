package com.system.educationSystem.dto;


public record CourseResponseDto(Long id, String name, String description, Long teacherId, String teacherFullName) { }
