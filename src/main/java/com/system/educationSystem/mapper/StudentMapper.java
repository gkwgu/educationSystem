package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.model.StudentEntity;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {
    public StudentResponseDto toDto(StudentEntity student){
        return new StudentResponseDto(
                student.getId(),
                student.getLastName(),
                student.getFirstName(),
                student.getGroup().getId(),
                student.getGroup().getName()
        );
    }
}
