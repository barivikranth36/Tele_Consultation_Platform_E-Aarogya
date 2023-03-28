package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.Repository.PatientRepository;
import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // -------------------------- Testing DAO Layer --------------------------------------

    @Override
    public List<Patient> getPatient() {
        try {

            return (List<Patient>) this.patientRepository.findAll();

        } catch (Exception e) {
            System.out.println("Error Occured while fetching all patients");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addPatient(PatientDetails patientDetails) {
        return false;
    }

    @Override
    public Patient getPatientByPatientId(long patientId) {
        try {
            return patientRepository.findById(patientId).get();
        } catch (Exception e) {
            System.out.println("Error Occured while fetching patient by patient Id");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient findByEmail(String email) {

        try {
            return patientRepository.findByEmail(email);
        } catch (Exception e) {
            System.out.println("Error occured while fetching patient by email");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient getPatientByPhoneNumber(String phoneNumber) {
        try {
            Patient patient = patientRepository.findByPhoneNo(phoneNumber);
            if (patient != null) {
                return patient;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error Occured while verifying phone number");
            e.printStackTrace();
            return null;
        }
    }
}
