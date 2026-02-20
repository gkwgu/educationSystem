package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.model.StudentEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface StudentMapper {
    public StudentResponseDto toDto(StudentEntity student);
}
