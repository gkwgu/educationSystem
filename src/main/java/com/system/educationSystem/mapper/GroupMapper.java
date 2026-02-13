package com.system.educationSystem.mapper;

import com.system.educationSystem.dto.GroupDto;
import com.system.educationSystem.dto.GroupResponseDto;
import com.system.educationSystem.model.GroupEntity;
import org.springframework.stereotype.Component;


@Component
public class GroupMapper {
    public GroupEntity toEntity(GroupDto dto){
        GroupEntity group=new GroupEntity();
        group.setName(dto.getName());
        return group;
    }

    public GroupResponseDto toDto(GroupEntity group){
        return new GroupResponseDto(
                group.getId(),
                group.getName()
        );
    }
}
