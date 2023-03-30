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
            System.out.println("Error Occurred while fetching all patients");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientByPatientId(long patientId) {
        try {
            if(patientRepository.findById(patientId).isPresent())
                return patientRepository.findById(patientId).get();
            else return null;
        } catch (Exception e) {
            System.out.println("Error Occurred while fetching patient by patient Id");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient findByEmail(String email) {

        try {
            return patientRepository.findByEmail(email);
        } catch (Exception e) {
            System.out.println("Error occurred while fetching patient by email");
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
            System.out.println("Error Occurred while verifying phone number");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient updatePatient(Patient patient, long patientId) {
        Patient updatedPatient = patientRepository.findById(patientId).get();

        updatedPatient.setTitle(patient.getTitle());
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setPhoneNo(patient.getPhoneNo());
        updatedPatient.setPincode(patient.getPincode());
        updatedPatient.setAddr(patient.getAddr());
        updatedPatient.setCity(patient.getCity());
        updatedPatient.setDob(patient.getDob());
        updatedPatient.setGender(patient.getGender());
        updatedPatient.setEmail(patient.getEmail());

        return patientRepository.save(updatedPatient);
    }
}
