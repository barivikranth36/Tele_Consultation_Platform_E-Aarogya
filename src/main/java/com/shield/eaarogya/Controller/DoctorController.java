package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ----------------------------------------- Register a Doctor -----------------------------------------
    @PostMapping("/registerDoctor")
    public DoctorDetails registerDoctor(@RequestBody DoctorDetails doctorDetails) {
        return doctorService.addDoctor(doctorDetails);
    }

    // ------------------------------------- Get List of all Doctors ------------------------------------------
    @GetMapping("/getAllDoctors")
    public List<DoctorDetails> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

}
