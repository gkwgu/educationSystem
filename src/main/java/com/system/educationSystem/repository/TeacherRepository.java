package com.system.educationSystem.repository;

import com.system.educationSystem.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
}
