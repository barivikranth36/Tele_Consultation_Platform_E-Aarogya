package com.shield.eaarogya.DAO;

import com.shield.eaarogya.Entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorDAO extends CrudRepository<Doctor, Integer> {
    // all the basic CRUD functionalities will be provided by this interface, you don't have to implement anything
}
