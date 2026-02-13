package com.system.educationSystem.service;

import com.system.educationSystem.dto.TeacherDto;
import com.system.educationSystem.dto.TeacherResponseDto;
import com.system.educationSystem.mapper.TeacherMapper;
import com.system.educationSystem.model.TeacherEntity;
import com.system.educationSystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherResponseDto save(TeacherDto dto){
        TeacherEntity teacher=teacherMapper.toEntity(dto);
        return teacherMapper.toDto( teacherRepository.save(teacher));
    }

    public TeacherResponseDto update(Long id,TeacherDto dto){
        TeacherEntity updateTeacher =teacherRepository.findById(id).
                orElseThrow(()->new RuntimeException("Преподаватель не найден"));
        updateTeacher.setFirstName(dto.getFirstName());
        updateTeacher.setLastName(dto.getLastName());
        return teacherMapper.toDto(teacherRepository.save(updateTeacher));
    }

    public void delete(Long id){
        TeacherEntity teacher =teacherRepository.findById(id).
                orElseThrow(()->new RuntimeException("Преподаватель не найден"));
        teacherRepository.delete(teacher);
    }
}
