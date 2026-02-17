package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.TeacherDto;
import com.system.educationSystem.dto.TeacherResponseDto;
import com.system.educationSystem.model.TeacherEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TeacherMapper {

    public TeacherEntity toEntity(TeacherDto dto);

    public TeacherResponseDto toDto(TeacherEntity teacher);
}
