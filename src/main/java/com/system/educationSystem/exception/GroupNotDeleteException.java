package com.system.educationSystem.exception;

public class GroupNotDeleteException extends RuntimeException{
    public GroupNotDeleteException(){
        super("Группу нельзя удалить, в ней есть студенты");
    }
}
