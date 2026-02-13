package com.system.educationSystem.controller;


import com.system.educationSystem.dto.TeacherDto;
import com.system.educationSystem.dto.TeacherResponseDto;
import com.system.educationSystem.model.TeacherEntity;
import com.system.educationSystem.repository.TeacherRepository;
import com.system.educationSystem.service.TeacherService;
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
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public TeacherResponseDto save(@RequestBody TeacherDto teacher){
        return teacherService.save(teacher);
    }

    @PutMapping("/{id}")
    public TeacherResponseDto update(@PathVariable Long id, @RequestBody TeacherDto teacher){
        return teacherService.update(id,teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        teacherService.delete(id);
    }


}
