package com.system.educationSystem.dto;

public record ErrorResponse(
        int status,
        String message
) {}
