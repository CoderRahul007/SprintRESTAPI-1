package com.SpringRest.REST.controller;

import com.SpringRest.REST.entity.Department;
import com.SpringRest.REST.errors.DepartmentNotFoundException;
import com.SpringRest.REST.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody Department department){
        LOGGER.info("Inside Save Department Function");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> fetchAllDepartmentList(){
        LOGGER.info("Inside Fetch All Department Function");
        return departmentService.fetchAllDepartment();
    }

    @GetMapping("/getDepartmentById/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return  departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartmentById( @PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully " + departmentId;
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartmentById( @PathVariable("id") Long departmentId , @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId , department);

    }

    @GetMapping("/getDepartmentByName/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
