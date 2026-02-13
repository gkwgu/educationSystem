package com.system.educationSystem.service;


import com.system.educationSystem.dto.GroupDto;
import com.system.educationSystem.dto.GroupResponseDto;
import com.system.educationSystem.mapper.GroupMapper;
import com.system.educationSystem.model.GroupEntity;
import com.system.educationSystem.repository.GroupRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    public final GroupMapper groupMapper;
    public final GroupRepositoty groupRepository;

    public GroupResponseDto save(GroupDto dto){
        GroupEntity group=groupMapper.toEntity(dto);
        return groupMapper.toDto(groupRepository.save(group));
    }

    public GroupResponseDto update(Long id, GroupDto dto){
        GroupEntity updateGroup =groupRepository.findById(id).
                orElseThrow(()->new RuntimeException("Группа не найдена"));
        updateGroup.setName(dto.getName());
        return groupMapper.toDto(groupRepository.save(updateGroup));
    }

    public void delete(Long id){
        GroupEntity group =groupRepository.findById(id).
                orElseThrow(()->new RuntimeException("Группа не найдена"));
        if(!group.getStudents().isEmpty()){
            throw new RuntimeException("Группу нельзя удалить, в ней есть студенты");
        }
        groupRepository.delete(group);
    }
}
