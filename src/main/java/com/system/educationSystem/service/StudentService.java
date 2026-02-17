package com.system.educationSystem.service;


import com.system.educationSystem.dto.StudentDto;
import com.system.educationSystem.dto.StudentResponseDto;
import com.system.educationSystem.exception.GroupNotFoundException;
import com.system.educationSystem.exception.StudentNotFoundException;
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
        GroupEntity group=groupRepositoty.findById(dto.groupId()).
                orElseThrow(()-> new RuntimeException("Такой группы нет"));
        StudentEntity student=new StudentEntity();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setGroup(group);
        return studentMapper.toDto(studentRepository.save(student));
    }

    public StudentResponseDto update(Long id, StudentDto dto){
        StudentEntity updateStudent=studentRepository.findById(id).
                orElseThrow(()-> new StudentNotFoundException(id));
        GroupEntity group=groupRepositoty.findById(dto.groupId()).
                orElseThrow(()-> new GroupNotFoundException(dto.groupId()));
        updateStudent.setFirstName(dto.firstName());
        updateStudent.setLastName(dto.lastName());
        updateStudent.setGroup(group);
        return studentMapper.toDto(studentRepository.save(updateStudent));
    }

    public void delete(Long id){
        StudentEntity student=studentRepository.findById(id).
                orElseThrow(()-> new StudentNotFoundException(id));
        studentRepository.delete(student);
    }
}
