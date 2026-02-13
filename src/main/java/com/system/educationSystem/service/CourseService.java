package com.system.educationSystem.service;

import com.system.educationSystem.dto.CourseDto;
import com.system.educationSystem.dto.CourseResponseDto;
import com.system.educationSystem.dto.StudentDto;
import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.mapper.CourseMapper;
import com.system.educationSystem.model.CourseEntity;
import com.system.educationSystem.model.GroupEntity;
import com.system.educationSystem.model.StudentEntity;
import com.system.educationSystem.model.TeacherEntity;
import com.system.educationSystem.repository.CourseRepository;
import com.system.educationSystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;

    public CourseResponseDto save(CourseDto dto){
        TeacherEntity teacher=teacherRepository.findById(dto.getTeacherId()).
                orElseThrow(()->new RuntimeException("Такого преподавателя нет"));
        CourseEntity course=new CourseEntity();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setTeacher(teacher);
        return courseMapper.toDto(courseRepository.save(course));
    }

    public CourseResponseDto update(Long id, CourseDto dto){
        CourseEntity updateCourse=courseRepository.findById(id).
                orElseThrow(()->new RuntimeException("Курс не найден"));
        TeacherEntity teacher=teacherRepository.findById(dto.getTeacherId()).
                orElseThrow(()->new RuntimeException("Такого преподавателя нет"));
        updateCourse.setName(dto.getName());
        updateCourse.setDescription(dto.getDescription());
        updateCourse.setTeacher(teacher);
        return courseMapper.toDto(courseRepository.save(updateCourse));
    }

    public void delete(Long id){
        CourseEntity course=courseRepository.findById(id).
                orElseThrow(()->new RuntimeException("Курс не найден"));
        courseRepository.delete(course);
    }
}
