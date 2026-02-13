package com.system.educationSystem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ScheduleViewDto {
    private final String courseName;
    private final String teacherName;
    private final LocalDateTime lessonTime;
}
