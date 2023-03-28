package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.DoctorService;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    // ---------------------------------------- Phone Number Verification ---------------------------------------
//    @GetMapping("/verifyPhoneNumber/{phoneNumber}")
//    public String verifyPhoneNumber(@PathVariable String phoneNumber) {
//
//        if(patientService.getPatientByPhoneNumber(Long.parseLong(phoneNumber))) {
//            return "Patient";
//        } else if (doctorService.getDoctorByPhoneNumber(Long.parseLong(phoneNumber))) {
//            return "Doctor";
//        } else
//            return "None";
//    }

    // -------------------------------- Verify Doctor Phone Number ---------------------------------------
    @GetMapping("/verifyDoctorPhoneNumber/{phoneNumber}")
    public boolean verifyDoctorPhoneNumber(@PathVariable String phoneNumber) {
        DoctorDetails doctorDetails = doctorService.getDoctorByPhoneNumber(phoneNumber);
        if(doctorDetails != null)
            return true;
        else return false;
    }

    //------------------------------------ Verify Patient Phone Number -------------------------------------
    @GetMapping("/verifyPatientPhoneNumber/{phoneNumber}")
    public boolean verifyPatientPhoneNumber(@PathVariable String phoneNumber) {
       Patient patient = patientService.getPatientByPhoneNumber(phoneNumber);
       if(patient != null) {
           return true;
       }
       else return false;
    }
}
