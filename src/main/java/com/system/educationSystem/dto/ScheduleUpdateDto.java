package com.system.educationSystem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ScheduleUpdateDto {
    private final LocalDateTime lessonTime;
}
