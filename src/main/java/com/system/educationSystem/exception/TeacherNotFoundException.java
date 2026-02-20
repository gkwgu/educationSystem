package com.system.educationSystem.exception;

public class TeacherNotFoundException extends NotFoundException{
    public TeacherNotFoundException(Long id){
        super("Преподаватель c id =" + id + " не найден");
    }
}
