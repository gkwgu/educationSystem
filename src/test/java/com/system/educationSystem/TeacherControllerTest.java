package com.system.educationSystem;

import com.system.educationSystem.dto.CreateTeacherRequest;
import com.system.educationSystem.dto.TeacherDtoUpdate;
import com.system.educationSystem.dto.TeacherResponse;
import com.system.educationSystem.dto.TeacherResponseDto;
import com.system.educationSystem.model.TeacherEntity;
import com.system.educationSystem.repository.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherControllerTest extends AbstractIT{
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void createTeacher_success() {

        CreateTeacherRequest request = new CreateTeacherRequest();
        request.setFirstName("Иван");
        request.setLastName("Иванов");
        ResponseEntity<TeacherResponse> response =
                restTemplate.postForEntity(
                        "/api/teacher",
                        request,
                        TeacherResponse.class
                );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFirstName()).isEqualTo("Иван");
        assertThat(response.getBody().getLastName()).isEqualTo("Иванов");
        assertThat(response.getBody().getId()).isNotNull();
    }

    @AfterEach
    void teacherDelete(){
        teacherRepository.deleteAll();
    }

    private TeacherEntity newTeacher;
    @BeforeEach
    void createTeacher(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setFirstName("Николай");
        teacher.setLastName("Сидоров");

        newTeacher = teacherRepository.save(teacher);
    }

    @Test
    void updateTeacher_success() {
        TeacherDtoUpdate request = new TeacherDtoUpdate();
        request.setFirstName("Updated");
        request.setLastName("Teacher");

        HttpEntity<TeacherDtoUpdate> entity = new HttpEntity<>(request);

        ResponseEntity<TeacherResponse> response =
                restTemplate.exchange(
                        "/api/teacher/" + newTeacher.getId(),
                        HttpMethod.PUT,
                        entity,
                        TeacherResponse.class
                );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFirstName()).isEqualTo("Updated");
        assertThat(response.getBody().getLastName()).isEqualTo("Teacher");
    }

    @Test
    void deleteTeacher_success() {
        ResponseEntity<Void> response =
                restTemplate.exchange(
                        "/api/teacher/" + newTeacher.getId(),
                        HttpMethod.DELETE,
                        null,
                        Void.class
                );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(teacherRepository.findById(newTeacher.getId())).isEmpty();
    }
}