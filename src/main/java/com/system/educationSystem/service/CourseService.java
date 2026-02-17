package com.system.educationSystem.service;

import com.system.educationSystem.dto.CourseDto;
import com.system.educationSystem.dto.CourseResponseDto;
import com.system.educationSystem.exception.CourseNotFoundException;
import com.system.educationSystem.exception.TeacherNotFoundException;
import com.system.educationSystem.mapper.CourseMapper;
import com.system.educationSystem.model.CourseEntity;
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
        TeacherEntity teacher=teacherRepository.findById(dto.teacherId()).
                orElseThrow(()->new TeacherNotFoundException(dto.teacherId()));
        CourseEntity course=new CourseEntity();
        course.setName(dto.name());
        course.setDescription(dto.description());
        course.setTeacher(teacher);
        return courseMapper.toDto(courseRepository.save(course));
    }

    public CourseResponseDto update(Long id, CourseDto dto){
        CourseEntity updateCourse=courseRepository.findById(id).
                orElseThrow(()->new CourseNotFoundException(id));
        TeacherEntity teacher=teacherRepository.findById(dto.teacherId()).
                orElseThrow(()->new TeacherNotFoundException(dto.teacherId()));
        updateCourse.setName(dto.name());
        updateCourse.setDescription(dto.description());
        updateCourse.setTeacher(teacher);
        return courseMapper.toDto(courseRepository.save(updateCourse));
    }

    public void delete(Long id){
        CourseEntity course=courseRepository.findById(id).
                orElseThrow(()->new CourseNotFoundException(id));
        courseRepository.delete(course);
    }
}
