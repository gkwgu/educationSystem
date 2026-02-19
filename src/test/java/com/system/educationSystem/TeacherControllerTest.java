package com.system.educationSystem;

import com.system.educationSystem.dto.CreateTeacherRequest;
import com.system.educationSystem.dto.TeacherResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class TeacherControllerTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17")
            .withDatabaseName("test_db")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);

        registry.add("spring.jpa.hibernate.ddl-auto", () -> "none");
        registry.add("spring.liquibase.enabled", () -> "true");
        registry.add("spring.jpa.properties.hibernate.id.new_generator_mappings", () -> "false");
        registry.add("spring.jpa.hibernate.use-new-id-generator-mappings", () -> "false");
    }

    @Autowired
    private TestRestTemplate restTemplate;

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
}