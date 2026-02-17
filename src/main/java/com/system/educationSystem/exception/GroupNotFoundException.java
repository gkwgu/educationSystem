package com.system.educationSystem.exception;

public class GroupNotFoundException extends NotFoundException{
    public GroupNotFoundException(Long id){
        super("Группа c id =" + id + " не найдена");
    }
}
