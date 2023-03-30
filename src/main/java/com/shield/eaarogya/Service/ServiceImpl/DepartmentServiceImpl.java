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
        try {
            return departmentRepository.save(department);
        } catch (Exception e) {
            System.out.println("Error Occurred while saving department to database.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> fetchDepartmentList() {
        try {
            return departmentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Occurred while fetching all the departments.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department getDepartmentById(int department_id) {
        try {
            if(departmentRepository.findById(department_id).isPresent())
                return departmentRepository.findById(department_id).get();
            else return null;
        } catch (Exception e) {
            System.out.println("Error Occurred while fetching department through department id.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department getDepartmentByName(String department_name) {
        try {
            return departmentRepository.findDepartmentByDepartmentName(department_name);
        } catch (Exception e) {
            System.out.println("Error Occurred while fetching department based on department name.");
            e.printStackTrace();
            return null;
        }
    }
}
