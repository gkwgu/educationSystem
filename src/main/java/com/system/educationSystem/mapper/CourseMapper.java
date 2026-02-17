package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.CourseResponseDto;
import com.system.educationSystem.model.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    public CourseResponseDto toDto(CourseEntity course);
}
