package com.system.educationSystem.service;


import com.system.educationSystem.dto.ScheduleDto;
import com.system.educationSystem.dto.ScheduleUpdateDto;
import com.system.educationSystem.dto.ScheduleViewDto;
import com.system.educationSystem.exception.CourseNotFoundException;
import com.system.educationSystem.exception.GroupNotFoundException;
import com.system.educationSystem.exception.ScheduleNotFoundException;
import com.system.educationSystem.model.CourseEntity;
import com.system.educationSystem.model.GroupEntity;
import com.system.educationSystem.model.ScheduleEntity;
import com.system.educationSystem.repository.CourseRepository;
import com.system.educationSystem.repository.GroupRepositoty;
import com.system.educationSystem.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final GroupRepositoty groupRepository;

    public void addGroupToCourse(ScheduleDto dto){
        CourseEntity course=courseRepository.findById(dto.courseId()).
                orElseThrow(()->new CourseNotFoundException(dto.courseId()));
        GroupEntity group =groupRepository.findById(dto.groupId()).
                orElseThrow(()->new GroupNotFoundException(dto.groupId()));
        ScheduleEntity schedule=new ScheduleEntity();
        schedule.setGroup(group);
        schedule.setCourse(course);
        schedule.setLessonTime(dto.lessonTime());
        schedule.setTeacher(course.getTeacher());

        scheduleRepository.save(schedule);
    }

    public void delete(Long scheduleId) {
        ScheduleEntity schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
        scheduleRepository.delete(schedule);
    }

    public void updateTime(Long scheduleId, ScheduleUpdateDto dto) {

        ScheduleEntity schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException(scheduleId));

        schedule.setLessonTime(dto.lessonTime());
        scheduleRepository.save(schedule);
    }

    public List<ScheduleViewDto> getScheduleForGroup(Long groupId) {
        return scheduleRepository.findByGroupId(groupId)
                .stream().map(s -> new ScheduleViewDto(
                        s.getCourse().getName(),
                        s.getTeacher().getFirstName() + " " + s.getTeacher().getLastName(),
                        s.getLessonTime()
                ))
                .toList();
    }

    public List<ScheduleViewDto> getScheduleForTeacher(Long teacherId) {
        return scheduleRepository.findByTeacherId(teacherId)
                .stream()
                .map(s -> new ScheduleViewDto(
                        s.getCourse().getName(),
                        s.getTeacher().getFirstName() + " " + s.getTeacher().getLastName(),
                        s.getLessonTime()
                ))
                .toList();
    }
}
