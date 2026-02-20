package com.system.educationSystem.dto;

import java.time.LocalDateTime;
public record ScheduleViewDto(String courseName, String teacherName, LocalDateTime lessonTime) { }
