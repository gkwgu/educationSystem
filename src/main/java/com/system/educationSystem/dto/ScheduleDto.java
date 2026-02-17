package com.system.educationSystem.dto;

import java.time.LocalDateTime;

public record ScheduleDto (Long groupId, Long courseId, LocalDateTime lessonTime) { }
