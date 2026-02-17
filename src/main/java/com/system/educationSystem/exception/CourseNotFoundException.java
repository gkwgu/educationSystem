package com.system.educationSystem.exception;

public class CourseNotFoundException extends  NotFoundException{
    public CourseNotFoundException(Long id){
        super("Курс с id = " + id + " не найден");
    }

}
