package com.system.educationSystem.exception;

public class StudentNotFoundException extends NotFoundException{
    public StudentNotFoundException(Long id){
        super("Студент c id =" + id + " не найден");
    }
}
