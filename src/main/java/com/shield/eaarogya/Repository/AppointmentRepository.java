package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentId(long appointmentId);

    List<Appointment> findAllByDepartment_DepartmentName(String departmentName);

    // To get Appointments whose timestamp is less than the particular appointment timestamp and are of same department
    List<Appointment> findAllByDepartment_DepartmentNameAndAppointmentTimestampLessThan(
            String departmentName, Date appointmentTimestamp);

    Appointment findByPatient_PatientId(long patientId);

}
