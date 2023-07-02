package com.SpringRest.REST.service;

import com.SpringRest.REST.entity.Department;
import com.SpringRest.REST.errors.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public  void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
