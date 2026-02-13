package com.system.educationSystem.controller;


import com.system.educationSystem.dto.CourseDto;
import com.system.educationSystem.dto.CourseResponseDto;
import com.system.educationSystem.dto.StudentDto;
import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.service.CourseService;
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
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CourseResponseDto save(@RequestBody CourseDto course){
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public CourseResponseDto update(@PathVariable Long id, @RequestBody CourseDto course){
        return courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }
}
