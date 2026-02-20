package com.system.educationSystem.controller;

import com.system.educationSystem.dto.StudentDto;
import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.service.StudentService;
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
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public StudentResponseDto save(@RequestBody StudentDto student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id, @RequestBody StudentDto student){
        return studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
