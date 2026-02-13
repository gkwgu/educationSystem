package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.CourseResponseDto;
import com.system.educationSystem.model.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseResponseDto toDto(CourseEntity course){
        return new CourseResponseDto(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getTeacher().getId(),
                course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName()
                );
    }
}
