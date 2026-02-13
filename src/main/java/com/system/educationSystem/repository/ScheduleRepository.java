package com.system.educationSystem.repository;

import com.system.educationSystem.model.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
    List<ScheduleEntity> findByGroupId(Long groupId);

    List<ScheduleEntity> findByTeacherId(Long teacherId);
}
