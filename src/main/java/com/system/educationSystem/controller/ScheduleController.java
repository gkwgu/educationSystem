package com.system.educationSystem.controller;


import com.system.educationSystem.dto.ScheduleDto;
import com.system.educationSystem.dto.ScheduleUpdateDto;
import com.system.educationSystem.dto.ScheduleViewDto;
import com.system.educationSystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public void addGroupToCourse(@RequestBody ScheduleDto schedule){
        scheduleService.addGroupToCourse(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateTime(
            @PathVariable Long id,
            @RequestBody ScheduleUpdateDto dto) {
        scheduleService.updateTime(id, dto);
    }

    @GetMapping("/group/{groupId}")
    public List<ScheduleViewDto> getGroupSchedule(@PathVariable Long groupId) {
        return scheduleService.getScheduleForGroup(groupId);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<ScheduleViewDto> getTeacherSchedule(@PathVariable Long teacherId) {
        return scheduleService.getScheduleForTeacher(teacherId);
    }
}
