package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.TeacherDto;
import com.system.educationSystem.dto.TeacherResponseDto;
import com.system.educationSystem.model.TeacherEntity;
import org.springframework.stereotype.Component;


@Component
public class TeacherMapper {

    public TeacherEntity toEntity(TeacherDto dto){
        TeacherEntity teacher=new TeacherEntity();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        return teacher;
    }

    public TeacherResponseDto toDto(TeacherEntity teacher){
        return new TeacherResponseDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName()
        );
    }
}
