package com.system.educationSystem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ScheduleDto {
    private final Long groupId;
    private final Long courseId;
    private final LocalDateTime lessonTime;
}
