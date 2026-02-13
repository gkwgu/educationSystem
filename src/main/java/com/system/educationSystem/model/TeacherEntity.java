package com.system.educationSystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String lastName;
    private String firstName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseEntity> courses = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<ScheduleEntity> schedules=new ArrayList<>();

}
