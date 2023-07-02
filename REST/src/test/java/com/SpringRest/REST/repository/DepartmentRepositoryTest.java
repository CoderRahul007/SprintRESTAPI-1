package com.SpringRest.REST.repository;

import com.SpringRest.REST.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

// For testing the JPA Repository so annotating with DataJpaTest
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;
    // to store the data in DB for mocking and then delete when the test is completed

    // called before each test case
    @BeforeEach
    void setUp() {
        // Here we are using the builder pattern where we can create the object using few params
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME-001")
                .departmentAddress("Delhi")
                .build();
        // persisting the department object into DB
        entityManager.persist(department);

    }

    @Test
    public void  whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName() , "Mechanical Engineering");

    }
}