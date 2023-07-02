package com.SpringRest.REST.service;

import com.SpringRest.REST.entity.Department;
import com.SpringRest.REST.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private  DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CS")
                .departmentAddress("Kanpur")
                .departmentCode("CS-01")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data Based On Department")
    // to disable the test case @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CS";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName , found.getDepartmentName());
    }
}