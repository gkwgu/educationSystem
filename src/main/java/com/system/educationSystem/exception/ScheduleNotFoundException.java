package com.system.educationSystem.exception;

public class ScheduleNotFoundException extends NotFoundException{
    public ScheduleNotFoundException(Long id){
        super("Расписание c id =" + id + " не найдено");
    }
}
