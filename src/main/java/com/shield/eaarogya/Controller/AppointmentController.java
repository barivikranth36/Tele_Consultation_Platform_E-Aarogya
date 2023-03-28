package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.AppointmentDetails;
import com.shield.eaarogya.Entity.Appointment;
import com.shield.eaarogya.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    // -------------------------------------- Request an Appointment ------------------------------------------
    @PostMapping("/requestAppointment")
    public long requestAppointment(@RequestBody AppointmentDetails appointmentDetails) {

        return appointmentService.requestAppointment(appointmentDetails);

//        System.out.println("Patient Name = " + appointmentDetails.getPatientId());
//        System.out.println("Department Name = " + appointmentDetails.getDepartmentName());
//        System.out.println("Timestamp = " + appointmentDetails.getAppointmentTimestamp().toString());
//        return true;
    }

    // ------------------------------------- Get list of all Appointments -------------------------------
    @GetMapping("/getAllAppointments")
    public List<AppointmentDetails> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // --------------------------------------- Delete a Particular Appointment ----------------------------------
    @DeleteMapping("/deleteAppointment/{appointmentId}")
    public boolean deleteAppointment(@PathVariable String appointmentId) {
        return appointmentService.deleteAppointment(Long.parseLong(appointmentId));
    }

    // -------------------------------- Patients waiting based on appointment Id ---------------------------------------------
    @GetMapping("/waitingPatients/{appointmentId}")
    public int waitingPatients(@PathVariable long appointmentId) {
        return appointmentService.waitingPatients(appointmentId);
    }

    // -------------------------- Get List of all Appointments for particular department ----------------------
    @GetMapping("/getAllAppointments/{departmentName}")
    public List<AppointmentDetails> getAllAppointments(@PathVariable String departmentName) {
        return appointmentService.getAppointmentsByDepartment(departmentName);
    }

    //
}
