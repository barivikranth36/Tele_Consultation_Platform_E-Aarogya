package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.Repository.DepartmentRepository;
import com.shield.eaarogya.Entity.Department;
import com.shield.eaarogya.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int department_id) {
        return departmentRepository.findById(department_id).get();
    }

    @Override
    public Department getDepartmentByName(String department_name) {
        return departmentRepository.findDepartmentByDepartmentName(department_name);
    }
}
