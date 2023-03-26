package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.AppointmentDetails;
import com.shield.eaarogya.Entity.Appointment;
import com.shield.eaarogya.Entity.Department;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Repository.AppointmentRepository;
import com.shield.eaarogya.Service.AppointmentService;
import com.shield.eaarogya.Service.DepartmentService;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public long requestAppointment(AppointmentDetails appointmentDetails) {
        try {
            Department department = departmentService.getDepartmentByName(appointmentDetails.getDepartmentName());
            Patient patient = patientService.getPatientByPatientId(appointmentDetails.getPatientId());

            Appointment appointment = new Appointment(patient, department,
                    appointmentDetails.getAppointmentTimestamp());

            Appointment savedAppointment = appointmentRepository.save(appointment);

            return savedAppointment.getAppointmentId();

        } catch (DataIntegrityViolationException d) {
            return -1;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Occured");
            return -1;
        }
    }

    @Override
    public List<AppointmentDetails> getAllAppointments() {
        List<AppointmentDetails> appointmentDetailsList = new ArrayList<>();

        List<Appointment> appointmentList = appointmentRepository.findAll();
        for(Appointment appointment: appointmentList) {
            appointmentDetailsList.add(new AppointmentDetails(
                    appointment.getAppointmentId(),
                    appointment.getAppointmentTimestamp(),
                    appointment.getPatient().getPatientId(),
                    appointment.getDepartment().getDepartmentName()
            ));
        }

        return appointmentDetailsList;
    }

    @Override
    public boolean deleteAppointment(long appointmentId) {

        try {
            Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);
            appointmentRepository.delete(appointment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int waitingPatients(long appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);
        List<Appointment> appointmentList = appointmentRepository.findAllByDepartment_DepartmentNameAndAppointmentTimestampLessThan(
                appointment.getDepartment().getDepartmentName() , appointment.getAppointmentTimestamp());

        return appointmentList.size();
    }

    @Override
    public List<AppointmentDetails> getAppointmentsByDepartment(String departmentName) {
        List<Appointment> appointmentList = appointmentRepository.findAllByDepartment_DepartmentName(departmentName);

        List<AppointmentDetails> appointmentDetailsList = new ArrayList<>();

        for(Appointment appointment: appointmentList) {
            appointmentDetailsList.add(new AppointmentDetails(appointment.getAppointmentId(),
                    appointment.getAppointmentTimestamp(), appointment.getPatient().getPatientId(),
                    appointment.getDepartment().getDepartmentName()));
        }

        return appointmentDetailsList;
    }
}
