package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.GroupDto;
import com.system.educationSystem.dto.GroupResponseDto;
import com.system.educationSystem.model.GroupEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GroupMapper {
    public GroupEntity toEntity(GroupDto dto);

    public GroupResponseDto toDto(GroupEntity group);
}
