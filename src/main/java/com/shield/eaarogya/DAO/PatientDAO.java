package com.shield.eaarogya.DAO;

import com.shield.eaarogya.Entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDAO extends CrudRepository<Patient, Long> {
}
