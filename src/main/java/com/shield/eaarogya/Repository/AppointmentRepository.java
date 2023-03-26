package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    public Appointment findByAppointmentId(long appointmentId);

    public List<Appointment> findAllByDepartment_DepartmentName(String departmentName);

    // To get Appointments whose timestamp is less than the particular appointment timestamp and are of same department
    public List<Appointment> findAllByDepartment_DepartmentNameAndAppointmentTimestampLessThan(
            String departmentName, Date appointmentTimestamp);
}
