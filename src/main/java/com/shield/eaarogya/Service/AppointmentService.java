package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.AppointmentDetails;
import com.shield.eaarogya.Entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentService {

    // ------------------------------------- request Appointment ---------------------------------------
    public long requestAppointment(AppointmentDetails appointmentDetails);

    // ------------------------------------- Get list of all Appointments -------------------------------
    public List<AppointmentDetails> getAllAppointments();

    // -------------------------------------- Delete a specific Appointment --------------------------------------
    public boolean deleteAppointment(long appointmentId);

    // -------------------------------------- Delete a specific Appointment --------------------------------------
    public boolean deleteAppointmentByPatientId(long patientId);

    // ---------------------- Get list of all waiting patients (Queue) for a particular department -----------------
    public int waitingPatients(long appointment);

    // ----------------------- Get list of all appointments for a particular department ---------------------------
    public List<AppointmentDetails> getAppointmentsByDepartment(String departmentName);

    // ------------------------ Check if any appointment is present for a patient ---------------------------------
    public boolean checkAppointment(long patientId);
}
