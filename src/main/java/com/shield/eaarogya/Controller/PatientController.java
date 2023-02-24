package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    // ------------------------------ Testing the DAO layer ------------------------------
    @GetMapping("/test")
    public String testThis() {
        return this.patientService.testThis();
    }

    // -------------------------------- Get all Patients --------------------------------
    @GetMapping("/getPatients")
    public List<Patient> getPatients() {
        return this.patientService.getPatient();
    }

    // -------------------------------- Adding Patient to database -------------------------------
    @PostMapping("/addPatient")
    public boolean addPatient(PatientDetails patientDetails) {
        try {
            return this.patientService.addPatient(patientDetails);
        }
        catch (Exception e) {
            return false;
        }
    }
}
