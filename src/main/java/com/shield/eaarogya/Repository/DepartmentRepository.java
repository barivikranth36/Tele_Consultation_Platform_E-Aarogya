package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findDepartmentByDepartmentName(String departmentName);
}
