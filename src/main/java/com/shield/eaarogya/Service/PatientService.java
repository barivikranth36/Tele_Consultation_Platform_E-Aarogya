package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;

import java.util.List;

public interface PatientService {

    // ------------------------- for Testing DAO layer -------------------------------
    public String testThis();

    public List<Patient> getPatient();

    public boolean addPatient(PatientDetails patientDetails);

    public Patient getPatientByPatientId(long patientId);

    public Patient findByEmail(String email);
}
