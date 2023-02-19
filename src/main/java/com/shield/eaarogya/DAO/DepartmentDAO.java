package com.shield.eaarogya.DAO;

import com.shield.eaarogya.Entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDAO extends CrudRepository<Department, Integer> {
}
