package com.system.educationSystem.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentResponseDto {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final Long groupId;
    private final String groupName;

}
