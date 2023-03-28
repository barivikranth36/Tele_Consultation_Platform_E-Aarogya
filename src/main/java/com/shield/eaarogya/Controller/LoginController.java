package com.shield.eaarogya.Controller;

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
    @GetMapping("/verifyPhoneNumber/{phoneNumber}")
    public String verifyPhoneNumber(@PathVariable String phoneNumber) {

        if(patientService.verifyPhoneNumber(Long.parseLong(phoneNumber))) {
            return "Patient";
        } else if (doctorService.verifyPhoneNumber(Long.parseLong(phoneNumber))) {
            return "Doctor";
        } else
            return "None";
    }
}
