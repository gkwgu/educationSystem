package com.system.educationSystem.repository;

import com.system.educationSystem.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
