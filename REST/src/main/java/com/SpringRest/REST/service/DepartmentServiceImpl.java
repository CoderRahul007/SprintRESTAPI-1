package com.SpringRest.REST.service;

import com.SpringRest.REST.entity.Department;
import com.SpringRest.REST.errors.DepartmentNotFoundException;
import com.SpringRest.REST.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    private Department noDepartment;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department>  department = departmentRepository.findById((departmentId));
        if (department.isEmpty()){
            throw new DepartmentNotFoundException("Department With the ID is not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        if (departmentRepository.findById(departmentId).isPresent()) {
            Department dp = departmentRepository.findById(departmentId).get();
            if (Objects.nonNull(department.getDepartmentName()) &&
                    !"".equalsIgnoreCase(department.getDepartmentName())) {
                dp.setDepartmentName(department.getDepartmentName());
            }

            if (Objects.nonNull(department.getDepartmentAddress()) &&
                    !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                dp.setDepartmentAddress(department.getDepartmentAddress());
            }

            if (Objects.nonNull(department.getDepartmentCode()) &&
                    !"".equalsIgnoreCase(department.getDepartmentCode())) {
                dp.setDepartmentCode(department.getDepartmentCode());
            }

            return departmentRepository.save(dp);
        }
        return noDepartment;
    }

    public Department findByDepartmentName(String departmentName){
        return null;

    }
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        //return  departmentRepository.findByDepartmentName(departmentName);
    }


}
