package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;

import java.util.List;

public interface PatientService {

    // ------------------------- for Testing DAO layer -------------------------------

    public List<Patient> getPatient();

    public Patient addPatient(Patient patient);

    public Patient getPatientByPatientId(long patientId);

    public Patient findByEmail(String email);

    public Patient getPatientByPhoneNumber(String phoneNumber);

    public Patient updatePatient(Patient patient, long patientId);
}
