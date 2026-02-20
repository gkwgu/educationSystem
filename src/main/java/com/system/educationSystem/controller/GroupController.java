package com.system.educationSystem.controller;


import com.system.educationSystem.dto.GroupDto;
import com.system.educationSystem.dto.GroupResponseDto;
import com.system.educationSystem.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/group")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public GroupResponseDto save(@RequestBody GroupDto group){
        return groupService.save(group);
    }

    @PutMapping("/{id}")
    public GroupResponseDto update(@PathVariable Long id, @RequestBody GroupDto group){
        return groupService.update(id,group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        groupService.delete(id);
    }
}
