package com.shield.eaarogya.Service;

import com.shield.eaarogya.Entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department getDepartmentById(int department_id);

    public Department getDepartmentByName(String department_name);
}
