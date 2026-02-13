package com.system.educationSystem.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StudentDto {
    private final String lastName;
    private final String firstName;
    private final Long groupId;
}
