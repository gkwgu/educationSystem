package com.system.educationSystem.service;


import com.system.educationSystem.dto.StudentDto;
import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.mapper.StudentMapper;
import com.system.educationSystem.model.GroupEntity;
import com.system.educationSystem.model.StudentEntity;
import com.system.educationSystem.repository.GroupRepositoty;
import com.system.educationSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepositoty groupRepositoty;
    private final StudentMapper studentMapper;

    public StudentResponseDto save(StudentDto dto){
        GroupEntity group=groupRepositoty.findById(dto.getGroupId()).
                orElseThrow(()-> new RuntimeException("Такой группы нет"));
        StudentEntity student=new StudentEntity();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGroup(group);
        return studentMapper.toDto(studentRepository.save(student));
    }

    public StudentResponseDto update(Long id, StudentDto dto){
        StudentEntity updateStudent=studentRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Студент не найден"));
        GroupEntity group=groupRepositoty.findById(dto.getGroupId()).
                orElseThrow(()-> new RuntimeException("Такой группы нет"));
        updateStudent.setFirstName(dto.getFirstName());
        updateStudent.setLastName(dto.getLastName());
        updateStudent.setGroup(group);
        return studentMapper.toDto(studentRepository.save(updateStudent));
    }

    public void delete(Long id){
        StudentEntity student=studentRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Студент не найден"));
        studentRepository.delete(student);
    }
}
